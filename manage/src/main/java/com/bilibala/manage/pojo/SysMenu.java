package com.bilibala.manage.pojo;

import java.util.ArrayList;
import java.util.List;


/**
 * 系统菜单对象
 * 
 * @project manage
 * @author smile
 * @createDate 2016年7月11日
 */
public class SysMenu{

	private long menuid;//菜单id
	
	private long parentid;//父菜单id
	
	private String menuitem;//菜单项
	
	private String url;//菜单url
	
	private long sort;//菜单排序
	
	private List<SysFunc> oper_list=new ArrayList<SysFunc>();//菜单拥有的功能
	
	private List<SysMenu> childMenu=new ArrayList<SysMenu>();//菜单的子菜单

//	@JsonProperty(name="menuid")
	public long getMenuid() {
		return menuid;
	}

	public void setMenuid(long menuid) {
		this.menuid = menuid;
	}

//	@JsonProperty(name="parentid")
	public long getParentid() {
		return parentid;
	}

	public void setParentid(long parentid) {
		this.parentid = parentid;
	}

//	@JsonProperty(name="menuitem")
	public String getMenuitem() {
		return menuitem;
	}

	public void setMenuitem(String menuitem) {
		this.menuitem = menuitem;
	}

//	@JsonProperty(name="url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

//	@JsonProperty(name="menu_list")
	public List<SysMenu> getChildMenu() {
		return childMenu;
	}

	public void addChildMenu(SysMenu childMenu) {
		this.childMenu.add(childMenu);
	}

//	@JsonProperty(name="oper_list")
	public List<SysFunc> getOper_list() {
		return oper_list;
	}

	public void addOper(SysFunc sysFunc) {
		oper_list.add(sysFunc);
	}
	
//	@JsonProperty(name="sort")
	public long getSort() {
		return sort;
	}

	public void setSort(long sort) {
		this.sort = sort;
	}
}
