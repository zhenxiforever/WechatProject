package com.bilibala.manage.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bilibala.exception.PlatformException;
import com.bilibala.manage.dao.model.SysMenu;
import com.bilibala.manage.dao.model.SysUser;
import com.bilibala.manage.dao.po.Result;
import com.bilibala.manage.helper.SystemHelper;
import com.bilibala.manage.service.ISysUserService;
import com.bilibala.manage.util.JsonUtil;

/**
 * 主页 以及用户登录处理action
 * 
 * @project manage
 * @author smile
 * @date 2016年7月25日
 */
public class IndexAction extends BaseAction{
	
	private Logger logger = Logger.getLogger(IndexAction.class);
	
	@Autowired
	private ISysUserService sysUserService;
	
	@Override
	public String execute(){
		
		if(sysuser==null){
			return RE_LOGIN;
		}
		return SUCCESS;
	}
	
	public void login(){
		Result rtn = new Result();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		try {
			SysUser user = sysUserService.login(userid, password);
			if(user!=null){
				if(user.getDisable()==1){
					rtn.setCode(1);
					rtn.setMessage("您的账户已被禁用，请联系管理员!");
				}else{
					rtn.setCode(0);
					rtn.setMessage("登录成功！");
					SystemHelper.setCurrentUserInfo(request, user);
				}
			}else{
				rtn.setCode(-1);
				rtn.setMessage("登录失败，用户名或密码错误！");
			}
		} catch (Exception ex){
			rtn.setCode(SYS_ERR_CODE);
			rtn.setMessage("登录失败，系统错误！");
		}
		logger.info("用户["+userid+"]登录，["+rtn.getMessage()+"]");
		JsonUtil.output(response, rtn);
	}
	
	public String loginout(){
		SystemHelper.setCurrentUserInfo(request, null);
		request.getSession().invalidate();
		logger.info("用户["+sysuser.getUsername()+"]退出系统！");
		return RE_LOGIN;
	}
	
	public void getMenuTreeByUser(){
		Result result = new Result();
		List<SysMenu> sysMenuList;
		try {
			sysMenuList = sysUserService.getSysMenuTree(sysuser.getUserid());
			if (sysMenuList != null)
				result.getData().put("menu_list", sysMenuList);
		} catch (PlatformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result.getData().put("sysuser",sysuser);
		String script = "var config=" + JsonUtil.object2json(result);
		JsonUtil.output(response, script);
	}
}
