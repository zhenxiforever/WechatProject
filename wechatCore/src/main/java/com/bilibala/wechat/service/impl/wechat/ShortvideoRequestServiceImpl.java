package com.bilibala.wechat.service.impl.wechat;

import javax.servlet.http.HttpServletRequest;

import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.response.ResponseMessage;
import com.bilibala.wechat.model.message.response.impl.TextResponseMessage;
import com.bilibala.wechat.service.IRequestService;

/**
 *  小视频消息对象服务
 * 
 * @author smile
 * @date 2016年6月29日
 */
public class ShortvideoRequestServiceImpl implements IRequestService {

	@Override
	public ResponseMessage handle(HttpServletRequest request,
			RequestMessage requestMessage) throws Exception {
		TextResponseMessage responseMessage = new TextResponseMessage(
				requestMessage);
		responseMessage.setContent("短视频消息回复");
		return responseMessage;
	}

}
