package com.bilibala.manage.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.bilibala.manage.action.IndexAction;
import com.bilibala.manage.dao.model.SysUser;
import com.bilibala.manage.dao.po.Result;
import com.bilibala.manage.helper.SystemErrCodeConstant;
import com.bilibala.manage.helper.SystemHelper;
import com.bilibala.manage.util.JsonUtil;
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

	Logger logger = Logger.getLogger(CheckLoginInterceptor.class);
	
	/**
	 * long
	 */
	private static final long serialVersionUID = 4644055543878949319L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
		HttpServletRequest request = ServletActionContext.getRequest();
		String type = request.getHeader("X-Requested-With");//请求类型
        String url = request.getRequestURL().toString();//请求URL
        logger.info("用户请求地址["+action.toString()+"]");
        if (action instanceof IndexAction || url.indexOf("loginuser.jsp") != -1) {
        	return invocation.invoke();
        }
        
       SysUser sysuser = SystemHelper.getCurrentUserInfo(request);
        if (sysuser != null) {
            return invocation.invoke();
        } else {
        	logger.info("用户登录失效或未登录！");
        	
        	/* ajax 请求
        	 * if ("XMLHttpRequest".equalsIgnoreCase(type))  
             {  
                 PrintWriter printWriter = ServletActionContext.getResponse().getWriter();  
                 printWriter.print("");  
                 printWriter.flush();  
                 printWriter.close();  

                 return null;  
             }  */
        	
            return "login";
        }
	}

}
