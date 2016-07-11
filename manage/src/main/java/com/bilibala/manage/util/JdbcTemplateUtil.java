package com.bilibala.manage.util;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * JDBCTemplate 工具类
 * 
 * @project manage
 * @author smile
 * @createDate 2016年7月11日
 */
public class JdbcTemplateUtil {

	public static WebApplicationContext beans;

	public static void init(ServletContext sc) {
		beans = WebApplicationContextUtils.getWebApplicationContext(sc);
	}

	public static Object getDAO(String daoName) {
		return beans.getBean(daoName);
	}

	public static JdbcTemplate getJdbcTemplate() {
		DataSource ds = (DataSource) beans.getBean("dataSource");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		return jdbcTemplate;
	}
}
