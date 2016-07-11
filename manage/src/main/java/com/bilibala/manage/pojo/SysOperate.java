package com.bilibala.manage.pojo;

/**
 * 用户操作按钮类
 * 
 * @project manage
 * @author smile
 * @createDate 2016年7月11日
 */
public class SysOperate {

	private String operid;//按钮id
	
	private String operkey;//按钮标识
	
	private String opername;//按钮名称

	public String getOperkey() {
		return operkey;
	}

	public void setOperkey(String operkey) {
		this.operkey = operkey;
	}

	public String getOpername() {
		return opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}
	
	
}
