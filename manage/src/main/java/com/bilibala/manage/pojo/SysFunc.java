package com.bilibala.manage.pojo;

/**
 * 系统功能对象
 * 
 * @project manage
 * @author smile
 * @createDate 2016年7月11日
 */
public class SysFunc {

	private int funcid;//功能id
	
	private long menuid;//功能所在菜单id
	
	private long parentid;//功能所在菜单的父菜单id
	
	private String menuitem;//功能所在菜单名称
	
	private String operid;//功能按钮id
	
	private String opername;//功能按钮名称
	
	private String operkey;//功能按钮标识
	
	private String foUrlid;//功能按钮url的id
	
	private String foUrl;//功能按钮url
	
	private String foUrlname;//功能按钮url名称
	
	private String foUrllog;//功能按钮url是否记录日志
	
	private int isset;

	public int getFuncid() {
		return funcid;
	}

	public void setFuncid(int funcid) {
		this.funcid = funcid;
	}

	public long getMenuid() {
		return menuid;
	}

	public void setMenuid(long menuid) {
		this.menuid = menuid;
	}

	public String getMenuitem() {
		return menuitem;
	}

	public void setMenuitem(String menuitem) {
		this.menuitem = menuitem;
	}
	
	public String getOpername() {
		return opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public long getParentid() {
		return parentid;
	}

	public void setParentid(long parentid) {
		this.parentid = parentid;
	}

	public int getIsset() {
		return isset;
	}

	public void setIsset(int isset) {
		this.isset = isset;
	}

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public String getOperkey() {
		return operkey;
	}

	public void setOperkey(String operkey) {
		this.operkey = operkey;
	}

	public String getFoUrlid() {
		return foUrlid;
	}

	public void setFoUrlid(String foUrlid) {
		this.foUrlid = foUrlid;
	}

	public String getFoUrl() {
		return foUrl;
	}

	public void setFoUrl(String foUrl) {
		this.foUrl = foUrl;
	}

	public String getFoUrlname() {
		return foUrlname;
	}

	public void setFoUrlname(String foUrlname) {
		this.foUrlname = foUrlname;
	}

	public String getFoUrllog() {
		return foUrllog;
	}

	public void setFoUrllog(String foUrllog) {
		this.foUrllog = foUrllog;
	}

	
}
