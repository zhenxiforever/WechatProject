package com.bilibala.manage.action;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @Description: Web层异常处理器,  -- 这里可以根据不同的异常，写多个方法去处理， 可以处理跳转页面请求，跳到异常指定的错误页， 
 *                                                       也可以处理Ajax请求，根据不通过异常，在页面输出不同的提示信息 
 *               operateExp          :   处理普通请求 
 *               operateExpAjax      ：       处理Ajax请求
 * 
 * @project manage
 * @author smile
 * @date 2016年9月27日
 */
@ControllerAdvice
public class ActionExceptionHandler {
	
    Logger logger =  Logger.getLogger(ActionExceptionHandler.class);  
  
    /** 
     * @Title: operateExp 
     * @Description: 全局异常控制，记录日志 
     *              任何一个方法发生异常，一定会被这个方法拦截到。然后，输出日志。封装Map并返回给页面显示错误信息：  
     *              特别注意：返回给页面错误信息只在开发时才使用，上线后，要把错误页面去掉，只打印log日志即可，防止信息外漏 
     * @param: @param ex 
     * @param: @param request 
     * @return: String 
     * @throws: 
     */  
//    @ExceptionHandler(RuntimeException.class)  
//    public String operateExp(RuntimeException ex, HttpServletRequest request) {  
//	    logger.error(ex.getMessage(), ex);  
//	    logger.info("************* ------ 异常信息已记录（" + DateUtil.getNow("yyyy-MM-dd HH:mm:ss")+ "） ------- ***********");  
//	    request.setAttribute("errorTips", ex.getMessage());  
//	    request.setAttribute("ex", ex);  
//	    return "exception/error";  
//    }  
}
