package com.bilibala.wechat.model.pojo;

/**
 * 微信返回请求接口情况结果类
 * 
 * @project wechat-model
 * @author smile
 * @createDate 2016年6月19日
 */
public class ResultMsgFromWechat {
	private String errCode;
	private String errMsg;
	private boolean isResSuccess;
	
	public ResultMsgFromWechat(){
	}
	
	public ResultMsgFromWechat(String errCode,String errMsg){
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

	public boolean isResSuccess() {
		return isResSuccess;
	}

	public void setResSuccess(boolean isResSuccess) {
		this.isResSuccess = isResSuccess;
	}
}
