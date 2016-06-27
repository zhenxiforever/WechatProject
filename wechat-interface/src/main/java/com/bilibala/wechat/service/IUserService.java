package com.bilibala.wechat.service;

import com.bilibala.wechat.model.pojo.Qrcode;
import com.bilibala.wechat.model.pojo.User;

public interface IUserService {

	/**
	 * 根据 帐户accountid ，openid获取用户信息
	 * @author smile
	 * @date 2016年6月27日
	 * @param accountid
	 * @param open_id
	 * @return User
	 */
	public User queryUserByOpenID(String accountid, String open_id);

	void saveOrUpdateUserInfo(String accountId, User user);

	void updateSubscribeFlag(String accountId, String openId, int issubscribe);

	Qrcode getQrcodeByTicket(String accountid, String ticket);

}
