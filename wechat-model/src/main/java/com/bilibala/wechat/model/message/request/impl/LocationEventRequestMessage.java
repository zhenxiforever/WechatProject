package com.bilibala.wechat.model.message.request.impl;

import org.dom4j.Document;

import com.bilibala.wechat.model.message.request.EventRequestMessage;


public class LocationEventRequestMessage extends EventRequestMessage{

	public LocationEventRequestMessage(String account_id, Document xmlDoc) {
		super(account_id, xmlDoc);
	}
	
//	/**
//	 * 转换为xml字符串
//	 * @param out
//	 */
//	@Override
//	protected void toString(StringBuilder out) {
//		out.append("	<Event>").append(this.event).append("</Event>\n");
//	}	

}
