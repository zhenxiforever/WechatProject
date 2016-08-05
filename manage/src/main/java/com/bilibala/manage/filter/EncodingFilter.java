package com.bilibala.manage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤器处理
 * 
 * @project manage
 * @author smile
 * @date 2016年7月25日
 */
public class EncodingFilter implements Filter{

	private String encoding = "UTF-8";

    private FilterConfig filterConfig;

    public EncodingFilter() {
        super();
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        this.filterConfig = filterConfig;
    }

    /**
     * 主要处理部分
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
            ServletException {
        try {
            request.setCharacterEncoding(encoding);
            filterChain.doFilter(request, response);
        } catch (ServletException sx) {
            filterConfig.getServletContext().log(sx.getMessage(), sx);
        } catch (IOException iox) {
            filterConfig.getServletContext().log(iox.getMessage());
        }

    }

    public void destroy() {
        this.encoding = null;
        this.filterConfig = null;
    }
}
