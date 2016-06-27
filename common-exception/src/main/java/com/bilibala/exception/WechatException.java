package com.bilibala.exception;

public class WechatException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6089924938198330801L;

	public WechatException(String message){
		super(message);
	}
	
	private String errcode;
	private String errmsg;
	
	public WechatException(String errcode,String errmsg){
		super(errmsg);
		this.errcode = errcode;
		this.errmsg = errmsg;
		
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	
}
