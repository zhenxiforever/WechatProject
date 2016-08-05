package com.bilibala.manage.filter;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.bilibala.manage.action.IndexAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 用户登录拦截器
 * 
 * @project manage
 * @author smile
 * @date 2016年7月25日
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
        String url = ServletActionContext.getRequest().getRequestURL().toString();
        if (action instanceof IndexAction || url.indexOf("loginuser.jsp") != -1) {
            return invocation.invoke();
        }
        Map session = invocation.getInvocationContext().getSession();
        if (session.get("userVo") != null) {
            return invocation.invoke();
        } else {
            return "login";
        }
	}

}
