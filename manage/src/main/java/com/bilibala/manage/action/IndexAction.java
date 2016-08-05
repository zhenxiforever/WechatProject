package com.bilibala.manage.action;

/**
 * 主页 以及用户登录处理action
 * 
 * @project manage
 * @author smile
 * @date 2016年7月25日
 */
public class IndexAction extends BaseAction{
	
	@Override
	public String execute(){
		if(sysuser==null){
			return "RE_LOGIN";
		}
		return SUCCESS;
	}
	
	public String login(){
		return SUCCESS;
	}
	
	public String loginout(){
		return SUCCESS;
	}
}
