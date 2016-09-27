package com.bilibala.common.log.util;

/**
 * 日志工具类 ，统一封装输出日志
 * 
 * @project common-log
 * @author smile
 * @date 2016年7月11日
 */
public class LoggerWebHand {

	private static LoggerWebHand logger = new LoggerWebHand();
	
	private LoggerWebHand(){}
	
	/**
	 * 获取 日志工具 对象,单例
	 *
	 * @author smile
	 * @data 2016年7月11日
	 * @param clazz
	 * @return LoggerHandler
	 */
	public static LoggerWebHand getLogger(){
		if(logger == null){
			logger = new LoggerWebHand();
		}
		return logger;
	}
	
	/**
	 * info 日志输出 </br>
	 * [INFO] [2016-07-11 15:02:30:000] [seriano] [{shcema}{openid}{tradetype}{output:msg}]
	 *
	 * @author smile
	 * @data 2016年7月11日
	 * @param msg : 日志输出信息
	 * @param Clazz  : 欲输出日志所在类 class
	 * @return void
	 */
	public void info(String msg,Class Clazz){
		
	}
	
	/**
	 * debug 日志输出 </br>
	 * [DEBU] [2016-07-11 15:02:30:000] [seriano] [{shcema}{openid}{tradetype}{output:msg}]
	 *
	 * @author smile
	 * @data 2016年7月11日
	 * @param msg 	: 日志输出信息
	 * @param Clazz  : 欲输出日志所在类 class
	 * @return void
	 */
	public void debug(String msg,Class Clazz){
		
	}
	
	/**
	 * warn 日志输出 </br>
	 * [WARN] [2016-07-11 15:02:30:000] [seriano] [{shcema}{openid}{tradetype}{output:msg}]
	 *
	 * @author smile
	 * @data 2016年7月11日
	 * @param msg : 日志输出信息
	 * @param Clazz  : 欲输出日志所在类 class
	 * @return void
	 */
	public void warn(String msg,Class Clazz){
		
	}
	
	/**
	 * warn 日志输出 </br>
	 * [WARN] [2016-07-11 15:02:30:000] [seriano] [{shcema}{openid}{tradetype}{output:msg;throw:exception}]
	 *
	 * @author smile
	 * @data 2016年7月11日
	 * @param msg :警告信息
	 * @param ex : 异常信息
	 * @return void
	 */
	public void warn(String msg,Exception ex){
		
	}
	
	/**
	 * err 日志输出 </br>
	 * [ERRO] [2016-07-11 15:02:30:000] [seriano] [{shcema}{openid}{tradetype}{output:msg;throw:exception}]
	 *
	 * @author smile
	 * @data 2016年7月11日
	 * @param msg : 出错业务信息以及原因信息
	 * @param th : 出错异常信息
	 * @return void
	 */
	public void error(String msg,Throwable th){
		
	}
	
	/**
	 * err 日志输出 </br>
	 * [ERRO] [2016-07-11 15:02:30:000] [seriano] [{shcema}{openid}{tradetype}{output:‘默认信息’;throw:exception}]
	 *
	 * @author smile
	 * @data 2016年7月11日
	 * @param th : 出错异常信息
	 * @return void
	 */
	public void error(Throwable th){
		
	}
}
