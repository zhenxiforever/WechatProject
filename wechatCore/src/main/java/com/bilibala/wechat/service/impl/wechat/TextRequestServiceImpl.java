package com.bilibala.wechat.service.impl.wechat;

import javax.servlet.http.HttpServletRequest;

import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.request.impl.TextRequestMessage;
import com.bilibala.wechat.model.message.response.ResponseMessage;

/**
 * 文本消息对象服务
 * 
 */
public class TextRequestServiceImpl extends AbstractRequestService {
	
	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage 请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public ResponseMessage handle(HttpServletRequest request,RequestMessage requestMessage) throws Exception {
		TextRequestMessage textRequestMessage=(TextRequestMessage)requestMessage;
		return handle(textRequestMessage, "返回文本消息");
	}	
}
