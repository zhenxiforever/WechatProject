package com.bilibala.manage.service;

import java.util.List;

import com.bilibala.exception.PlateformeException;
import com.bilibala.manage.pojo.PojoDomain;
import com.bilibala.manage.pojo.SysMenu;
import com.bilibala.manage.pojo.SysOperate;
import com.bilibala.manage.pojo.SysRole;
import com.bilibala.manage.pojo.SysUser;

public interface SysUserService {

	/**
	 * 系统 用户登录
	 * @author smile
	 * @date 2016年7月11日
	 * @param loginName
	 * @param password
	 * @return SysUser
	 */
	public SysUser login(String loginName, String password);

	/**
	 * 获取用户可操作菜单
	 * @author smile
	 * @date 2016年7月11日
	 * @param userId
	 * @return SysMenu
	 */
	public SysMenu getSysMenuTree(String userId);

	/**
	 * 根据 用户id和菜单id 获取 用户操作按钮
	 * @author smile
	 * @date 2016年7月11日
	 * @param userId
	 * @param menuId
	 * @return List<SysOperate>
	 */
	public List<SysOperate> getOperByUserIdAndMenuId(String userId, long menuId);

	/**
	 * 获取 系统用户 列表
	 * @author smile
	 * @date 2016年7月11日
	 * @param page_number
	 * @param page_size
	 * @param roleids
	 * @param keyword
	 * @return PojoDomain<SysUser>
	 */
	public PojoDomain<SysUser> querySysUserList(int page_number, int page_size, int[] roleids, String keyword);

	/**
	 * 根据用户id 获取 用户信息
	 * @author smile
	 * @date 2016年7月11日
	 * @param userId
	 * @return SysUser
	 */
	public SysUser getSysUserById(String userId);

	/**
	 * 更新 系统用户信息
	 * @author smile
	 * @date 2016年7月11日
	 * @param sysUser void
	 */
	public void updateSysUser(SysUser sysUser);

	/**
	 * 获取 角色列表
	 * @author smile
	 * @date 2016年7月11日
	 * @return List<SysRole>
	 */
	public List<SysRole> querySysRoleList();

	/**
	 * 给用户添加角色
	 * @author smile
	 * @date 2016年7月11日
	 * @param adminId
	 * @param sysUser
	 * @param roleids
	 * @throws PlateformeException void
	 */
	public void saveSysUser(String adminId, SysUser sysUser, int[] roleids) throws PlateformeException;

	/**
	 * 更新系统用户的角色
	 * @author smile
	 * @date 2016年7月11日
	 * @param adminId
	 * @param sysUser
	 * @param roleids
	 * @throws PlateformeException void
	 */
	public void updateSysUser(String adminId, SysUser sysUser, int[] roleids) throws PlateformeException;

	/**
	 * 新增系统用户角色
	 * @author smile
	 * @date 2016年7月11日
	 * @param sysRole void
	 */
	public void saveSysRole(SysRole sysRole);

	/**
	 * 给用户 角色添加 功能
	 * @author smile
	 * @date 2016年7月11日
	 * @param userId
	 * @param roleId
	 * @param funcIds
	 * @throws PlateformeException void
	 */
	public void saveSysFuncByRoleId(String userId, int roleId, List<Integer> funcIds) throws PlateformeException;

}
