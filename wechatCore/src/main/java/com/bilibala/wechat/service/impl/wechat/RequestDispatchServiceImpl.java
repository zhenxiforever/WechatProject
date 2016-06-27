package com.bilibala.wechat.service.impl.wechat;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.response.ResponseMessage;
import com.bilibala.wechat.service.IRequestDispatchService;
import com.bilibala.wechat.service.IRequestService;

/**
 * 请求消息对象分发接口实现
 * 
 */
public class RequestDispatchServiceImpl implements IRequestDispatchService {

	private Map<String, IRequestService> componentMap;
	
	/**
	 * 设置请求消息对象处理服务的组件Map
	 * 具体参见：applicationContext.xml中<bean id="requestDispatchService">一节
	 * @param componentMap
	 */
	public void setComponentMap(Map<String, IRequestService> componentMap) {
		this.componentMap = componentMap;
	}
	
	/**
	 * 请求消息分发处理
	 * @param requestMessage 请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public ResponseMessage dispatch(HttpServletRequest request,RequestMessage requestMessage) throws Exception {
		IRequestService requestService = componentMap.get(requestMessage.getMsgType());
		if(requestService!=null){
			ResponseMessage responseMessage=requestService.handle(request,requestMessage);
			if(responseMessage != null && responseMessage.isEndFlag()) {
				requestMessage.getCurrentUserInfo();//.reset();
			}
			return responseMessage;
		}
		return null;
	}

}
