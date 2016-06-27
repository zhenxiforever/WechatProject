package com.bilibala.wechat.service.impl.wechat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;

import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.request.impl.LocationRequestMessage;
import com.bilibala.wechat.model.message.response.ResponseMessage;
import com.bilibala.wechat.model.message.response.impl.TextResponseMessage;

/**
 * 地理位置对象 消息服务
 * 
 * @project wechatCore
 * @author smile
 * @createDate 2016年6月27日
 */
public class LocationRequestServiceImpl extends AbstractRequestService {

	private static Logger logger = Logger.getLogger(LocationRequestServiceImpl.class);

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

		// TODO 上传地理位置逻辑处理暂时为空，后续根据需要在此处新增业务逻辑处理
		logger.info("------------------LocationRequestServiceImpl not deal");
		LocationRequestMessage locationRequestMessage = (LocationRequestMessage) requestMessage;

		TextResponseMessage responseMessage = new TextResponseMessage(
				requestMessage);
		String locationmsg = "dizhimorenhuifu";
		locationmsg = locationmsg.replace("{location}", locationRequestMessage
				.getLabel());

		responseMessage.setContent(locationmsg);

		return responseMessage;
	}

}
