package com.bilibala.exception;

public class PlatformException extends Exception {

	private String errCode;
	
	private String errMsg;

	
	public PlatformException(String errMsg) {
		super(errMsg);
		this.errMsg = errMsg;
	}

	public PlatformException() {
		super();
	}

	public PlatformException(Throwable cause, String errMsg) {
		super(errMsg,cause);
		this.errMsg = errMsg;
	}

	public PlatformException(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
}
