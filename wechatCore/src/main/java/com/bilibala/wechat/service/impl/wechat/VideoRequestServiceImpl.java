package com.bilibala.wechat.service.impl.wechat;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.response.ResponseMessage;
import com.bilibala.wechat.model.message.response.impl.TextResponseMessage;

/**
 * 视频消息对象服务
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class VideoRequestServiceImpl extends AbstractRequestService {

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
		TextResponseMessage responseMessage = new TextResponseMessage(
				requestMessage);
		responseMessage.setContent("视频消息回复");
		return responseMessage;
	}

}
