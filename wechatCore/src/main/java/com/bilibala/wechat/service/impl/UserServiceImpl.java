package com.bilibala.wechat.service.impl;

import com.bilibala.wechat.dao.WechatUserDao;
import com.bilibala.wechat.model.pojo.Qrcode;
import com.bilibala.wechat.model.pojo.User;
import com.bilibala.wechat.service.IUserService;

/**
 * 关注用户服务接口实现
 * 
 */
public class UserServiceImpl implements IUserService {
	
	private WechatUserDao wechatUserDao;

	public void setWechatUserDao(WechatUserDao wechatUserDao) {
		this.wechatUserDao = wechatUserDao;
	}

	/**
	 * 根据openId和accountId获取关注用户信息
	 * @param accountId
	 * @param openId
	 * @return
	 */
	@Override
	public User queryUserByOpenID(String accountid, String open_id) {
		return wechatUserDao.queryUserByOpenID(accountid, open_id);
	}
	
	/**
	 * 保存或修改用户信息
	 * @param accountId
	 * @param user
	 */
	@Override
	public void saveOrUpdateUserInfo(String accountId,User user) {
		User dbUser=wechatUserDao.queryUserByOpenID(accountId, user.getOpenid());
		if(dbUser==null){
			user.setAccountid(accountId); 
			wechatUserDao.saveUser(user);
		}
		else{
			user.setId(dbUser.getId());
			user.setQrcodeid(dbUser.getQrcodeid());
			user.setAccountid(accountId); 
			wechatUserDao.updateUser(accountId, user);
		}
	}	
	
	/**
	 * 修改用户关注标识
	 * @param accountId
	 * @param openId
	 * @param issubscribe 1关注 ;-1取消关注
	 */
	@Override
	public void updateSubscribeFlag(String accountId, String openId,int issubscribe) {
		wechatUserDao.updateSubscribeFlag(accountId, openId, issubscribe);
	}
	
	/**
	 * 获取二维码对象
	 * @param accountid
	 * @param ticket
	 * @return
	 */
	@Override
	public Qrcode getQrcodeByTicket(String accountid, String ticket) {
		return wechatUserDao.getQrcodeByTicket(accountid, ticket);
	}

}
