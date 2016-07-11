package com.bilibala.manage.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统用户
 * 
 */
public class SysUser implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userid; //账号
	private String username; //姓名
	private String password; //密码
	private String tel; //电话
	private int disable;//是否禁用  0：否 1：是
	private List<SysRole> role_list;
	
	private final List<String> urlList = new ArrayList<String>();

	public void addAllUrl(List<String> list){
		if (list != null){
			this.urlList.addAll(list);
		}
	}
	
	public SysUser(){}
	
	public SysUser(String userid, String username, String password, String tel) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.tel = tel;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<SysRole> getRole_list() {
		return role_list;
	}
	public void setRole_list(List<SysRole> role_list) {
		this.role_list = role_list;
	}
	public int getDisable() {
		return disable;
	}
	public void setDisable(int disable) {
		this.disable = disable;
	}

	public boolean urlFilter(String url) {
		return this.urlList.contains(url);
	}
	
}
