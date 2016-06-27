package com.bilibala.wechat.dao;

import com.bilibala.wechat.model.pojo.Qrcode;
import com.bilibala.wechat.model.pojo.User;

public interface WechatUserDao {

	public User queryUserByOpenID(String accountid, String open_id);

	public void saveUser(User user);

	public void updateUser(String accountId, User user);

	public void updateSubscribeFlag(String accountId, String openId, int issubscribe);

	public Qrcode getQrcodeByTicket(String accountid, String ticket);

}
