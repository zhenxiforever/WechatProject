package com.bilibala.manage.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.bilibala.common.util.XSSReplaceUtils;

/**
 * 防XSS漏洞处理过滤器
 * 
 * @project manage
 * @author smile
 * @date 2016年7月25日
 */
public class XSSFilter implements Filter {
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {	
		chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	/**
	 * 处理所有参数以及变量
	 *
	 */
	final class RequestWrapper extends HttpServletRequestWrapper {
		public RequestWrapper(HttpServletRequest servletRequest) {
			super(servletRequest);
		}

		public String[] getParameterValues(String parameter) {
			String[] results = super.getParameterValues(parameter);
			if (results == null)
				return null;
			int count = results.length;
			String[] trimResults = new String[count];
			for (int i = 0; i < count; i++) {
				trimResults[i] = XSSReplaceUtils.antiXSS(results[i]);
			}
			return trimResults;
		}
		
		public String getParameter(String name) {
			String value = super.getParameter(name);
			if(value != null) {
				value = XSSReplaceUtils.antiXSS(value);
			}
			return value;
		}

		@Override
		public Map getParameterMap() {
			// TODO Auto-generated method stub
			Map<String, Object> map  =new HashMap<String, Object>();
			Map<String, Object> parameters = super.getParameterMap();
    		for (String key : parameters.keySet()) {
    			Object value = parameters.get(key);
    			if (value instanceof String[]) {
    				String[] values = (String[]) value;
    				for (int i = 0; i < values.length; i++) {
    					values[i] = XSSReplaceUtils.antiXSS(values[i]);
    				}
    				map.put(key, values);
    			}else{
    				map.put(key, value);
    			}
    		}
			return map;
		}
	}
}
