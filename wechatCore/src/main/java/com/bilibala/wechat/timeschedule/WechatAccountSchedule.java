package com.bilibala.wechat.timeschedule;

import java.util.HashMap;
import java.util.Map;

import com.bilibala.wechat.model.pojo.WechatAccount;
import com.bilibala.wechat.util.WechatUtil;

public class WechatAccountSchedule {

	private static Map<String, WechatUtil> account_comm_map = new HashMap<String, WechatUtil>();
	
	public static WechatUtil getWeChatUtil(String accountId) throws Exception {
		WechatUtil weChatUtil = account_comm_map.get(accountId);
		return weChatUtil;
	}

	public static void put(WechatAccount weixinAccount) {
		WechatUtil comm = account_comm_map.get(weixinAccount.getId());
		if (comm == null) {
			comm = new WechatUtil(weixinAccount);
			account_comm_map.put(weixinAccount.getId(), comm);
		} else if (!comm.getWeixinAccount().equals(weixinAccount)) {
			comm.setWeixinAccount(weixinAccount);
		}
	}
}
