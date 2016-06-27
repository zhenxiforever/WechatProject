package com.bilibala.wechat.service.impl;

import java.util.List;

import com.company.weixin.dao.WeixinMenuDao;
import com.company.weixin.pojo.WeixinMenu;
import com.company.weixin.service.WeixinMenuService;

/**
 * 微信菜单服务接口实现
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class WeixinMenuServiceImpl implements WeixinMenuService{
	
	private WeixinMenuDao weixinMenuDao;

	public void setWeixinMenuDao(WeixinMenuDao weixinMenuDao) {
		this.weixinMenuDao = weixinMenuDao;
	}

	/**
	 * 根据服务号ID获取菜单列表
	 * @param accountid
	 * @return
	 */
	public List<WeixinMenu> getMenu(String accountid) {
		String parent_id=null;
		List<WeixinMenu> first_menu_list=weixinMenuDao.queryMenuListByParentId(accountid,parent_id);
		for(WeixinMenu weixinMenu:first_menu_list){
			List<WeixinMenu> second_menu_list=weixinMenuDao.queryMenuListByParentId(accountid,weixinMenu.getId());
			weixinMenu.setSub_button(second_menu_list);
		}
		return first_menu_list;
	}

	/**
	 * 根据服务号ID更新菜单post标志
	 * @param accountid
	 */
	@Override
	public void updatePostFlag(String accountid) {
		weixinMenuDao.updatePostFlag(accountid);
	}
	
}
