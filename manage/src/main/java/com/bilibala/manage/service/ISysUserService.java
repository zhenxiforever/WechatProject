package com.bilibala.manage.service;

import java.util.List;

import com.bilibala.exception.PlatformException;
import com.bilibala.manage.dao.model.SysMenu;
import com.bilibala.manage.dao.model.SysUser;

/**
 * 系统用户处理接口
 * 
 * @project manage
 * @author smile
 * @date 2016年9月27日
 */
public interface ISysUserService {

	/**
	 * 用户登录
	 *
	 * @author smile
	 * @data 2016年9月19日
	 * @param userid
	 * @param password
	 * @throws PlatformException 
	 * @return SysUser
	 */
	public SysUser login(String userid,String password) throws PlatformException;

	/**
	 * 用户登录后获取用户菜单树
	 *
	 * @author smile
	 * @data 2016年9月27日
	 * @param userid
	 * @return
	 * @throws PlatformException 
	 * @return List<SysMenu>
	 */
	public List<SysMenu> getSysMenuTree(String userid) throws PlatformException;

}
