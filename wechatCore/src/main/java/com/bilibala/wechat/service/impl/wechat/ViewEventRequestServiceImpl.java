package com.bilibala.wechat.service.impl.wechat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;

import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.request.impl.ViewEventRequestMessage;
import com.bilibala.wechat.model.message.response.ResponseMessage;


/**
 * 点击菜单跳转链接的事件请求服务
 * 
 * @project wechatCore
 * @author smile
 * @createDate 2016年6月27日
 */
public class ViewEventRequestServiceImpl extends AbstractRequestService {

	private static Logger logger = Logger.getLogger(ViewEventRequestServiceImpl.class);

	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public ResponseMessage handle(HttpServletRequest request,RequestMessage requestMessage)
			throws JSONException {
		ResponseMessage responseMessage = null;
		
		ViewEventRequestMessage viewEventRequestMessage = (ViewEventRequestMessage) requestMessage;
		logger.info("----------url:"+viewEventRequestMessage.getEventKey());
		
		
		//返回的响应请求对象为null，为了让微信端直接跳转到URL
		return responseMessage;
	}

}
