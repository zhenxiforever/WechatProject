package com.bilibala.manage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
public class CheckLoginInterceptor extends AbstractInterceptor implements Filter{

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
        logger.info("用户请求地址["+url+"]["+invocation.getInvocationContext().getName()+"]");
        if (/*action instanceof IndexAction ||*/ url.indexOf("loginuser.jsp") != -1) {
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
        	
            return "RE_LOGIN";
        }
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        SysUser sysuser = SystemHelper.getCurrentUserInfo(req);
        if (sysuser == null) {
            if (req.getRequestURL().indexOf("loginuser.jsp") == -1) {

                String path = req.getContextPath();
                String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
                res.sendRedirect(basePath + "loginuser.jsp");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
	}

	
}
