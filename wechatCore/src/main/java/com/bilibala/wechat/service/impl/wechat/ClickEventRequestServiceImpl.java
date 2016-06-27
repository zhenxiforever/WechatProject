package com.bilibala.wechat.service.impl.wechat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.bilibala.wechat.dao.WechatMenuDao;
import com.bilibala.wechat.model.message.request.EventRequestMessage;
import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.response.ResponseMessage;
import com.bilibala.wechat.model.pojo.WechatMenu;

/**
 * 上报菜单事件请求服务
 * 
 * @project wechatCore
 * @author smile
 * @createDate 2016年6月27日
 */
public class ClickEventRequestServiceImpl extends AbstractRequestService {	

	private static Logger logger = Logger.getLogger(ClickEventRequestServiceImpl.class);

	private WechatMenuDao wechatMenuDao;
	
	public void setWechatMenuDao(WechatMenuDao wechatMenuDao) {
		this.wechatMenuDao = wechatMenuDao;
	}
	
	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public ResponseMessage handle(HttpServletRequest request,RequestMessage requestMessage) throws Exception {
		ResponseMessage responseMessage=null;
		EventRequestMessage eventRequestMessage=(EventRequestMessage)requestMessage;
		WechatMenu weixinMenu=wechatMenuDao.queryMenuById(requestMessage.getAccountId(),eventRequestMessage.getEventKey());
		if(weixinMenu!=null){
			responseMessage=handle(requestMessage, weixinMenu.getContent());
		}else{
			logger.info("---------------------weixinMenu is null,please check wxb_menu table data");
		}
		return responseMessage;
	}
	
}
