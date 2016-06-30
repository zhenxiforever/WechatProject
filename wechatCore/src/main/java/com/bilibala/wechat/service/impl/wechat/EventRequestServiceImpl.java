package com.bilibala.wechat.service.impl.wechat;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bilibala.wechat.model.message.request.EventRequestMessage;
import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.response.ResponseMessage;
import com.bilibala.wechat.service.wechat.IRequestService;

/**
 * 事件 请求服务
 * 
 * @project wechatCore
 * @author smile
 * @createDate 2016年6月27日
 */
public class EventRequestServiceImpl implements IRequestService {

	private Map<String, IRequestService> componentMap;

	public void setComponentMap(Map<String, IRequestService> componentMap) {
		this.componentMap = componentMap;
	}

	@Override
	public ResponseMessage handle(HttpServletRequest request,RequestMessage requestMessage)
			throws Exception {
		EventRequestMessage eventRequestMessage = (EventRequestMessage) requestMessage;
		IRequestService requestService = componentMap.get(eventRequestMessage.getEvent().toLowerCase());
		if (requestService != null) {
			ResponseMessage responseMessage = requestService.handle(request,eventRequestMessage);
			return responseMessage;
		}
		return null;
	}
}
