package com.bilibala.webapp.controller.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.bilibala.common.log.util.LoggerWebHand;
import com.bilibala.wechat.model.message.MessageConverter;
import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.response.ResponseMessage;
import com.bilibala.wechat.model.message.response.impl.TextResponseMessage;
import com.bilibala.wechat.model.pojo.WechatAccount;
import com.bilibala.wechat.mp.aes.AesException;
import com.bilibala.wechat.mp.aes.WXBizMsgCrypt;
import com.bilibala.wechat.service.IWechatAccountService;
import com.bilibala.wechat.service.wechat.IRequestDispatchService;

/**
 * 处理微信服务号请求与响应的控制类，核心类
 * 
 * @project webapp
 * @author smile
 * @date 2016年6月18日
 */
@Controller
public class WechatController {

	private static LoggerWebHand logger = LoggerWebHand
			.getLogger(WechatController.class);

	@Autowired
	private IRequestDispatchService requestDispatchService;

	@Autowired
	private IWechatAccountService WechatAccountService;

	/**
	 * 微信调用doGet接口的校验 公众号参数配置
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/WECHAT/HANDLER", method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("----------------------------doGet:",this.getClass());
		String accountid = request.getParameter("accountid");
		if (accountid == null || "".equals(accountid)) {
			logger.info("----------accountid is null,check url has accountid,for return",this.getClass());
			return;
		}

		WechatAccount account = WechatAccountService
				.getWechatAccountById(accountid);
		if (account == null) {
			logger.info("----------check wxb_wechat_account table has data accountid="
					+ accountid + ",for return",this.getClass());
			return;
		}

		String token = account.getToken();
		if (token != null) {
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			logger.info("--------------accountid=" + accountid + ",signature="
					+ signature + ",timestamp=" + timestamp + ",nonce=" + nonce
					+ ",echostr=" + echostr,this.getClass());

			if (echostr != null) {
				try {
					if (this.checkSignature(request, token)/** &&DataDicUtil.doField* (echostr)*/) {
						response.getWriter().print(echostr + "");
					}
				} catch (NoSuchAlgorithmException e) {
					logger.error("验证签名失败！", e);
				}
			}
		}
	}

	/**
	 * 微信调用doPost接口 接收 微信消息
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/WECHAT/HANDLER", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		logger.info("----------------------------doPost:",this.getClass());
		/* ((ServletRequest) response).setCharacterEncoding("UTF-8"); */
		response.setContentType("text/xml");
		String accountId = request.getParameter("accountid");
		if (accountId == null || "".equals(accountId)) {
			logger.info("----------accountid is null,check url has accountid,for return",this.getClass());
			this.replyMsg(response, "");
			return;
		}

		WechatAccount account = WechatAccountService
				.getWechatAccountById(accountId);
		if (account == null) {
			logger.info("----------check wxb_wechat_account table has data accountid="
					+ accountId + ",for return",this.getClass());
			this.replyMsg(response, "");
			return;
		}

		if (!checkSha(request, account.getToken())) {
			this.replyMsg(response, "");
			return;
		}

		String xml = "";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					request.getInputStream(), "UTF-8"));
			String line = in.readLine();
			while (line != null) {
				xml += line;
				line = in.readLine();
			}
		} catch (Exception e) {
			logger.error(e);
			return;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error("IOException", e);
				}
			}
		}

		// 安全模式(解密)
		if ("aes".equals(request.getParameter("encrypt_type"))) {
			logger.info("--------------encrypt_type:"
					+ request.getParameter("encrypt_type"),this.getClass());
			logger.info("--------------aes data:" + xml,this.getClass());
			xml = decryptXml(xml, request, account);
		}

		logger.info("--------------raw data:" + xml,this.getClass());
		if (xml == null) {
			return;
		}

		// 消息转换
		RequestMessage requestMessage = MessageConverter.convertMessage(
				accountId, xml);
		requestMessage.setLocalAddr(""/* request.getLocalAddr() */);
		requestMessage.setAccountId(accountId);
		ResponseMessage responseMessage = null;
		try {
			responseMessage = requestDispatchService.dispatch(request,
					requestMessage);
		} catch (Exception e) {
			logger.error("Exception:", e);
			TextResponseMessage textResponseMessage = new TextResponseMessage(
					requestMessage);
			textResponseMessage.setContent(""/*
											 * SystemParameterHelper.getValue(
											 * SysConfParam.WX_ERROR_INFO)
											 */);
			responseMessage = textResponseMessage;
		}
		if (responseMessage == null) {
			this.replyMsg(response, "");
			return;
		}
		String responseXml = "".equals(responseMessage) ? "" : responseMessage
				.toString();
		// 安全模式(加密)
		if ("aes".equals(request.getParameter("encrypt_type"))) {
			logger.info("--------------raw result data:" + responseXml,this.getClass());
			responseXml = encryptXml(responseXml, request, account);
			logger.info("--------------aes result data:" + responseXml,this.getClass());
		}

		this.replyMsg(response, responseXml);
	}

	/**
	 * 校验Sha
	 * 
	 * @param request
	 * @param token
	 * @return
	 */
	public boolean checkSha(HttpServletRequest request, String token) {
		try {
			return this.checkSignature(request, token);
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithmException:", e);
			return false;
		}
	}

	/**
	 * 验证签名</br> 加密/校验流程如下：</br> &nbsp;&nbsp;1.
	 * 将token、timestamp、nonce三个参数进行字典序排序</br> &nbsp;&nbsp;2.
	 * 将三个参数字符串拼接成一个字符串进行sha1加密</br> &nbsp;&nbsp;3.
	 * 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信</br>
	 * 
	 * @param request
	 * @param token
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private boolean checkSignature(HttpServletRequest request, String token)
			throws NoSuchAlgorithmException {
		logger.info("--------------------checkSignature,token:" + token,this.getClass());
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");

		logger.info("--------------signature=" + signature + ",timestamp="
				+ timestamp + ",nonce=" + nonce,this.getClass());
		/** 时间延迟验证 */
		/*
		 * long timefromdb =
		 * Long.parseLong(SystemParameterHelper.getValue(SysConfParam
		 * .WX_TIMESS))*1000; long systimes = (new Date()).getTime(); long
		 * revtimes = Long.parseLong(timestamp)*1000; long starttimes =
		 * systimes-timefromdb; long endtimes = systimes+timefromdb;
		 * //logger.info(timestamp); //logger.info(timefromdb);
		 * //logger.info(systimes); // if(revtimes<starttimes ||
		 * revtimes>endtimes){ //
		 * logger.info("----------timestamp check false----------"); // return
		 * false; // }
		 */
		String[] tempArr = new String[] { token, timestamp, nonce };
		Arrays.sort(tempArr);
		String tempStr = tempArr[0] + tempArr[1] + tempArr[2];
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(tempStr.getBytes());
		tempStr = this.byteArrayToHex(md.digest());
		logger.info("----------sha1 String:" + tempStr,this.getClass());

		if (tempStr.equalsIgnoreCase(signature)) {
			logger.info("--------------checkSignature:true",this.getClass());
			return true;
		} else {
			logger.info("--------------checkSignature:false",this.getClass());
			return false;
		}
	}

	/**
	 * 用于将字节数组换成成16进制的字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	public String byteArrayToHex(byte[] byteArray) {
		// 首先初始化一个字符数组，用来存放每个16进制字符
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };

		// new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
		char[] resultCharArray = new char[byteArray.length * 2];

		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}

		// 字符数组组合成字符串返回
		return new String(resultCharArray);
	}

	/**
	 * 对加密字符串进行解密
	 * 
	 * @param xmlstr
	 * @param request
	 * @return
	 */
	public String decryptXml(String xmlstr, HttpServletRequest request,
			WechatAccount account) {
		String result = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(xmlstr);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encrypt");
			String encrypt = nodelist1.item(0).getTextContent();

			// NodeList nodelist2 = root.getElementsByTagName("MsgSignature");
			// String msgSignature = nodelist2.item(0).getTextContent();
			String msgSignature = request.getParameter("msg_signature");

			String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
			String fromXML = String.format(format, encrypt);

			String token = account.getToken();
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");

			String appId = account.getAppid();
			String encodingAesKey = account.getAeskey();

			WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
			result = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
		} catch (DOMException e) {
			logger.error("DOMException", e);
		} catch (ParserConfigurationException e) {
			logger.error("ParserConfigurationException", e);
		} catch (SAXException e) {
			logger.error("SAXException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (AesException e) {
			logger.error("AesException", e);
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return result;
	}

	/**
	 * 对明文字符串进行加密
	 * 
	 * @param xmlstr
	 * @param request
	 * @return
	 */
	public String encryptXml(String xmlstr, HttpServletRequest request,
			WechatAccount account) {
		String result = null;
		try {
			String token = account.getToken();
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");

			String appId = account.getAppid();
			String encodingAesKey = account.getAeskey();

			WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
			result = pc.encryptMsg(xmlstr, timestamp, nonce);
		} catch (AesException e) {
			logger.error("AesException", e);
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return result;
	}

	private void replyMsg(HttpServletResponse response, String responseXml) {
		try {
			if (responseXml == null || "".equals(responseXml)) {
				responseXml = "success";
			}
			response.getWriter().print(responseXml);
			response.getWriter().close();
		} catch (Exception e) {
			logger.error("Exception:", e);
		}
		/*
		 * if(!"".equals(responseMessage)){
		 * MessageLogHelper.saveMessage(requestMessage, responseMessage); }
		 */
	}
}
