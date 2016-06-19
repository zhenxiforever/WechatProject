package com.bilibala.wechat.service.impl;

import java.util.List;

import com.bilibala.exception.WechatException;
import com.bilibala.wechat.model.pojo.NewsItem;
import com.bilibala.wechat.model.pojo.ResultMsgFromWechat;
import com.bilibala.wechat.model.pojo.TradeResultFromWechat;
import com.bilibala.wechat.model.pojo.UserOpenid;
import com.bilibala.wechat.model.pojo.WechatMenu;
import com.bilibala.wechat.model.pojo.WechatUser;
import com.bilibala.wechat.service.IWechatCommService;

public class WechatCommonServiceImpl implements IWechatCommService{

	@Override
	public WechatUser getUserInfo(String accountId, String openid) throws WechatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsgFromWechat createWXGroup(String accountId, String group_name) throws WechatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsgFromWechat updateWXGroup(String accountId, int group_id, String group_name) throws WechatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsgFromWechat updateWXGroupMember(String accountId, int to_group_id, String... open_id_list)
			throws WechatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createQrcode(String accountId, int action_type, int expire_seconds, int scene_id)
			throws WechatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsgFromWechat sendCustomTextMsg(String accountId, String openid, String content)
			throws WechatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsgFromWechat sendCustomMultiGraphicMsg(String accountId, String open_id, List<NewsItem> newsItems)
			throws WechatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsgFromWechat createWXMenu(String accountId, List<WechatMenu> menu_list) throws WechatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserOpenid getWXUserOpenId(String accountId, String next_openid) throws WechatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TradeResultFromWechat sendMsgTrade(String json, String accountId) throws WechatException {
		// TODO Auto-generated method stub
		return null;
	}

}
