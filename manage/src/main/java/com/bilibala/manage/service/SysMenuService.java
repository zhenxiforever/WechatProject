package com.bilibala.manage.service;

import java.util.List;

import com.bilibala.manage.pojo.PojoDomain;
import com.bilibala.manage.pojo.SysMenu;
import com.bilibala.manage.pojo.SysOperate;

/**
 * 系统菜单 操作
 * 
 * @project manage
 * @author smile
 * @createDate 2016年7月11日
 */
public interface SysMenuService {

	/**
	 * 获取系统 操作按钮
	 * @author smile
	 * @date 2016年7月11日
	 * @param page_number
	 * @param page_size
	 * @return PojoDomain<SysOperate>
	 */
	public PojoDomain<SysOperate> querySysOperate(int page_number,int page_size);
	
	/**新增系统操作按钮*/
	public void saveSysOperate(SysOperate operate);
	
	/**编辑系统操作按钮 */
	public void updateSysOperate(SysOperate operate);
	
	/**删除系统操作按钮*/
	public void deleteSysOperate(int operid);
	
	/**获取系统菜单*/
	public List<SysMenu> getSysMenu();
	
	/**新增系统菜单*/
	public void saveSysMenu(SysMenu sysMenu);
	
	/**编辑系统菜单*/
	public void updateSysMenu(SysMenu sysMenu);
	
	/**删除系统菜单*/
	public void deleteSysMenu(int menuid);
	
	/**获取系统操作按钮 */
	public List<SysOperate> getAllOperate();
	
	/**新增系统菜单功能*/
	public void saveSysMenuOperate(int menuid,int operid,String oprateUrlName,String oprateUrl,String logFlag);
	
	/**跟新系统菜单功能*/
	public void updateSysMenuOperate(int funcid,int operid,int oprateUrlid,String oprateUrlName,String oprateUrl,String logFlag);
	
	/**删除系统菜单功能*/
	public void deleteSysMenuOperate(int funcid,int oprateUrlid);
}
