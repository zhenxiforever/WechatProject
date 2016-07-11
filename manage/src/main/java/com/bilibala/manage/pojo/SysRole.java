package com.bilibala.manage.pojo;

public class SysRole {

	private static final long serialVersionUID = 1L;

	private int roleid;//角色id
	
	private String rolename;//角色名称
	
	private int disable;//是否禁用  0：否 1：是
	
	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public int getDisable() {
		return disable;
	}

	public void setDisable(int disable) {
		this.disable = disable;
	}
}
