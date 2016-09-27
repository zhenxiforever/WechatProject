package com.bilibala.manage.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.bilibala.manage.dao.model.SysUser;
import com.bilibala.manage.helper.SystemHelper;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础 请求 处理器
 * 
 * @project manage
 * @author smile
 * @date 2016年7月25日
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	protected final int SYS_ERR_CODE = 1000;
	protected final String RE_LOGIN = "RE_LOGIN";
	
	/**
	 * long
	 */
	private static final long serialVersionUID = -4080655783536342048L;
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	
	protected String clientIp;
	
	protected SysUser sysuser;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
        if ("".equals(clientIp) || clientIp == null)
        	clientIp = getIpAddr(request);
        sysuser = getLoginUser();
//        path = request.getContextPath();
//        basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
//                + "/";
	}

	public SysUser getLoginUser() {
        return SystemHelper.getCurrentUserInfo(request);
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 通过json串把数据传到前台
     *
     * @param msg
     */
    public void writeJsonToClient(String msg) {
    	  response.setContentType("text/json;charset=UTF-8");
        try {
            response.getWriter().write(msg);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
        }
    }

    /**
     * 返回错误信息
     */
    public void writeErrorJsonToClient() {
        response.setContentType("text/json;charset=UTF-8");
        try {
            response.getWriter().write("系统错误，请重试！");
            response.getWriter().flush();
            response.getWriter().close();
            return ;
        } catch (IOException e) {
        }
    }

    public void writeTextToClient(String msg) {
        response.setContentType("text/html");
        try {
            response.getWriter().write(msg);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
        }
    }

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public SysUser getSysuser() {
		return sysuser;
	}

	public void setSysuser(SysUser sysuser) {
		this.sysuser = sysuser;
	}
    
}
