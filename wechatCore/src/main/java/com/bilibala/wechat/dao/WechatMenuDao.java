package com.bilibala.wechat.dao;

import com.bilibala.wechat.model.pojo.WechatMenu;

public interface WechatMenuDao {

	public WechatMenu queryMenuById(String accountId, String eventKey);

}
