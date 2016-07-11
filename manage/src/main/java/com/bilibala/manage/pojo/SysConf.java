package com.bilibala.manage.pojo;

import java.io.Serializable;

/**
 * 系统参数
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class SysConf implements Serializable {

	private static final long serialVersionUID = 8244773375138866173L;

	private long id;
	private String key;
	private String value;
	private String description;
	private int approval_status;
	private int isedit;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public int getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(int approval_status) {
		this.approval_status = approval_status;
	}
	public int getIsedit() {
		return isedit;
	}
	public void setIsedit(int isedit) {
		this.isedit = isedit;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}

}
