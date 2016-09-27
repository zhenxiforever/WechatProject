package com.bilibala.manage.dao.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.bilibala.common.annotation.JsonObject;
import com.bilibala.common.annotation.JsonObjectProperty;
import com.bilibala.common.annotation.JsonProperty;

@JsonObject
public class Result implements Serializable{

	/**
	 * long
	 */
	private static final long serialVersionUID = -2334826554633817615L;

	
	private int code;
	private String message;
	
	//其它数据项
	private Map<String,Object> data = new HashMap<String,Object>();
	
	/**
	 * 获取属性：返回码
	 * 
	 * @return
	 */
	@JsonProperty(name="retcode")
	public int getCode() {
		return code;
	}
	
	/**
	 * 设置属性： 返回码
	 * 
	 * @param
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	/**
	 * 获取属性：返回信息
	 * 
	 * @return
	 */
	@JsonProperty(name="retmsg")
	public String getMessage() {
		return message;
	}
	
	/**
	 * 设置属性：返回信息
	 * 
	 * @param
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 获取属性：其它数据项
	 * 
	 * @return
	 */
	@JsonObjectProperty
	public Map<String, Object> getData() {
		return data;
	}
}
