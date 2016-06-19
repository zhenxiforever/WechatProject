package com.bilibala.common.log.pojo;

/**
 * 系统日志记录 父 vo
 * 
 * @project common-log
 * @author smile
 * @date 2016年6月18日
 */
public class BaseSystemLog {
	
	private String serno;
	private String msg;
	private String schema;
	public String getSerno() {
		return serno;
	}
	public void setSerno(String serno) {
		this.serno = serno;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	
}
