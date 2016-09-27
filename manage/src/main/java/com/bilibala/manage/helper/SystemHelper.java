package com.bilibala.manage.helper;

import javax.servlet.http.HttpServletRequest;

import com.bilibala.manage.dao.model.SysUser;

public class SystemHelper {

	private static final String USER_SESSION_KEY = "USER_SESSION_KEY";

	/**
	 * 根据请求对象取得当前用户信息对象
	 * 
	 * @param request
	 * @return
	 */
	public static SysUser getCurrentUserInfo(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(USER_SESSION_KEY);
		return obj==null?null:(SysUser)obj ;
	}

	/**
	 * 设置当前用户信息到session对象中
	 * 
	 * @param request
	 * @param u
	 */
	public static void setCurrentUserInfo(HttpServletRequest request,
			SysUser user) {
		request.getSession().setAttribute(USER_SESSION_KEY, user);
	}
}
