package com.bilibala.wechat.service.impl.wechat;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.response.ResponseMessage;
import com.bilibala.wechat.model.message.response.impl.TextResponseMessage;

/**
 * 链接消息对象服务
 * 
 * @project wechatCore
 * @author smile
 * @createDate 2016年6月27日
 */
public class LinkRequestServiceImpl extends AbstractRequestService {

	/**
	 * 请求消息处理
	 * @param requestMessage 请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public ResponseMessage handle(HttpServletRequest request,RequestMessage requestMessage) throws JSONException {
		TextResponseMessage responseMessage = new TextResponseMessage(requestMessage);
		responseMessage.setContent("link 消息默认回复");
		return responseMessage;
	}

}
