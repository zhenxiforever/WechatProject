package com.bilibala.wechat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bilibala.exception.WechatException;
import com.bilibala.wechat.model.pojo.NewsItem;
import com.bilibala.wechat.model.pojo.ResultMsgFromWechat;
import com.bilibala.wechat.model.pojo.TradeResultFromWechat;
import com.bilibala.wechat.model.pojo.WechatAccount;
import com.bilibala.wechat.model.pojo.WechatMenu;
import com.bilibala.wechat.model.pojo.WechatUser;
import com.bilibala.wechat.model.pojo.WechatUserOpenid;
import com.bilibala.wechat.service.IWechatAccountService;
import com.bilibala.wechat.service.IWechatCommService;
import com.bilibala.wechat.timeschedule.WechatAccountSchedule;
import com.bilibala.wechat.util.WechatUtil;

public class WechatCommonServiceImpl implements IWechatCommService{

	@Resource
	private IWechatAccountService wechatAccountService;
	
	
	public void setWechatAccountService(IWechatAccountService wechatAccountService) {
		this.wechatAccountService = wechatAccountService;
	}

	private WechatUtil getWechatUtil(String accountId) throws Exception{
		WechatUtil weChatUtil = WechatAccountSchedule.getWeChatUtil(accountId);
		if(weChatUtil==null){
			WechatAccount account = wechatAccountService.getWeixinAccountById(accountId);
			if(account!=null){
				WechatAccountSchedule.put(account);
				return WechatAccountSchedule.getWeChatUtil(accountId);
			}else{
				throw new Exception("accountId=" + accountId + "的微信公众账号参数未配置");
			}
		}else{
			return weChatUtil;
		}
	}
	
	@Override
	public WechatUser getUserInfo(String accountId, String openid) throws WechatException {
		try {
			WechatUtil wechatUtil = getWechatUtil(accountId);
			return wechatUtil.getWXUserInfo(openid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WechatException(e.getMessage());
		}
	}

	@Override
	public int createWXGroup(String accountId, String group_name) throws WechatException {
		try {
			WechatUtil wechatUtil = getWechatUtil(accountId);
			return wechatUtil.createWXGroup(group_name);
		} catch (WechatException we) {
			throw we;
		} catch(Exception e){
			e.printStackTrace();
			throw new WechatException(e.getMessage());
		}
	}

	@Override
	public ResultMsgFromWechat updateWXGroup(String accountId, int group_id, String group_name) throws WechatException {
		try {
			WechatUtil wechatUtil = getWechatUtil(accountId);
			wechatUtil.updateWXGroup(group_id, group_name);
			return new ResultMsgFromWechat(true);
		} catch (WechatException we) {
			throw we;
		} catch(Exception e){
			e.printStackTrace();
			throw new WechatException(e.getMessage());
		}
	}

	@Override
	public ResultMsgFromWechat updateWXGroupMember(String accountId, int to_group_id, String... open_id_list)
			throws WechatException {
		try {
			WechatUtil wechatUtil = getWechatUtil(accountId);
			for(String open_id:open_id_list)
				wechatUtil.updateWXGroupMember(open_id, to_group_id);
			return new ResultMsgFromWechat(true);
		} catch (WechatException we) {
			throw we;
		} catch(Exception e){
			e.printStackTrace();
			throw new WechatException(e.getMessage());
		}
	}

	@Override
	public String createQrcode(String accountId, int action_type, int expire_seconds, int scene_id)
			throws WechatException {
		try {
			WechatUtil wechatUtil = getWechatUtil(accountId);
			return wechatUtil.createQrcode(action_type, expire_seconds, scene_id);
		} catch (WechatException we) {
			throw we;
		} catch(Exception e){
			e.printStackTrace();
			throw new WechatException(e.getMessage());
		}
	}

	@Override
	public ResultMsgFromWechat sendCustomTextMsg(String accountId, String openid, String content)
			throws WechatException {
		try {
			WechatUtil wechatUtil = getWechatUtil(accountId);
			wechatUtil.sendCustomTextMsg(openid, content);
			return new ResultMsgFromWechat(true);
		} catch (WechatException we) {
			throw we;
		} catch(Exception e){
			e.printStackTrace();
			throw new WechatException(e.getMessage());
		}
	}

	@Override
	public ResultMsgFromWechat sendCustomMultiGraphicMsg(String accountId, String open_id, List<NewsItem> newsItems)
			throws WechatException {
		try {
			WechatUtil wechatUtil = getWechatUtil(accountId);
			wechatUtil.sendCustomMultiGraphicMsg(open_id, newsItems);
			return new ResultMsgFromWechat(true);
		} catch (WechatException we) {
			throw we;
		} catch(Exception e){
			e.printStackTrace();
			throw new WechatException(e.getMessage());
		}
	}

	@Override
	public ResultMsgFromWechat createWXMenu(String accountId, List<WechatMenu> menu_list) throws WechatException {
		try {
			WechatUtil wechatUtil = getWechatUtil(accountId);
			wechatUtil.createWXMenu(menu_list);
			return new ResultMsgFromWechat(true);
		} catch (WechatException we) {
			throw we;
		} catch(Exception e){
			e.printStackTrace();
			throw new WechatException(e.getMessage());
		}
	}

	@Override
	public WechatUserOpenid getWXUserOpenId(String accountId, String next_openid) throws WechatException {
		try {
			WechatUtil wechatUtil = getWechatUtil(accountId);
			return wechatUtil.getWXUserOpenId(next_openid);
		} catch (WechatException we) {
			throw we;
		} catch(Exception e){
			e.printStackTrace();
			throw new WechatException(e.getMessage());
		}
	}

	@Override
	public TradeResultFromWechat sendMsgTrade(String json, String accountId) throws WechatException {
		try {
			WechatUtil wechatUtil = getWechatUtil(accountId);
			return wechatUtil.sendTemplateMsg(json);
		} catch (WechatException we) {
			throw we;
		} catch(Exception e){
			e.printStackTrace();
			throw new WechatException(e.getMessage());
		}
	}

}
