package com.bilibala.manage.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.bilibala.manage.dao.po.Result;
import com.bilibala.manage.helper.SystemErrCodeConstant;
import com.bilibala.manage.util.JsonUtil;
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

	Logger logger = Logger.getLogger(CheckAuthorityInterceptor.class);
	/**
	 * long
	 */
	private static final long serialVersionUID = 4922172895146108766L;

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String type = request.getHeader("X-Requested-With");//请求类型
		// 有权限
		try{
    		return actionInvocation.invoke();
    	}catch(Exception ex){
    		logger.error("请求["+actionInvocation.getInvocationContext().getName()+"]处理失败！", ex);
    		if ("XMLHttpRequest".equalsIgnoreCase(type))  
            {  
    			Result rtn = new Result();
    			rtn.setCode(SystemErrCodeConstant.SYS_ERR_CODE);
    			rtn.setMessage(SystemErrCodeConstant.SYS_ERR_MSG);
    			HttpServletResponse  response = ServletActionContext.getResponse();
    			JsonUtil.output(response, rtn);
                return null;  
            }else{
            	return "index";
            }
    	}
		
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
