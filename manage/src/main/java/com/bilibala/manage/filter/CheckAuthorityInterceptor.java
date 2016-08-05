package com.bilibala.manage.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 权限验证 拦截器
 * 
 * @project manage
 * @author smile
 * @date 2016年7月25日
 */
public class CheckAuthorityInterceptor extends AbstractInterceptor{

	/**
	 * long
	 */
	private static final long serialVersionUID = 4922172895146108766L;

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// 有权限
		return actionInvocation.invoke();
    }
	
	public void writeToClient(HttpServletResponse response,String msg) {
        try {
            response.getWriter().write(msg);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
        }
    }
}
