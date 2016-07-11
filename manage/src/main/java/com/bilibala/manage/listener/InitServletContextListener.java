package com.bilibala.manage.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bilibala.manage.util.BeanUtil;
import com.bilibala.manage.util.JdbcTemplateUtil;

public class InitServletContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(arg0.getServletContext());
		JdbcTemplateUtil.init(arg0.getServletContext());
		BeanUtil.init(context);
	}

}
