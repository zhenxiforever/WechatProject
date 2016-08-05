package com.bilibala.manage.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统后台管理用户
 * 
 * @project manage
 * @author smile
 * @date 2016年7月25日
 */
public class SysUser {

	private static final long serialVersionUID = 1L;
	private String userid; //账号
	private String username; //姓名
	private String password; //密码
	private String tel; //电话
	private int disable;//是否禁用  0：否 1：是
	private List<SysRole> role_list;
	
	private final List<String> urlList = new ArrayList<String>();

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getDisable() {
		return disable;
	}

	public void setDisable(int disable) {
		this.disable = disable;
	}

	public List<SysRole> getRole_list() {
		return role_list;
	}

	public void setRole_list(List<SysRole> role_list) {
		this.role_list = role_list;
	}

	public List<String> getUrlList() {
		return urlList;
	}
	
}
