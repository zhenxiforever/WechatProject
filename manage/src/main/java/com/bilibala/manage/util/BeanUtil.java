package com.bilibala.manage.util;

import org.springframework.context.ApplicationContext;

/**
 * spring 实体bean 工具类
 * 
 * @project manage
 * @author smile
 * @createDate 2016年7月11日
 */
public class BeanUtil {
	private static ApplicationContext context;

	public static void init(ApplicationContext ac) {
		context = ac;
	}

	public static Object getBean(Class<Object> c) {
		return context.getBean(c);
	}
}
