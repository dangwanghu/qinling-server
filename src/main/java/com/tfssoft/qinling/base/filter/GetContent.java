package com.tfssoft.qinling.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tfssoft.qinling.base.filter.util.SysContent;

/**
 * 获取变量过滤器
 * @author DWH
 *
 */
public class GetContent implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		SysContent.setRequest((HttpServletRequest) request);
		SysContent.setResponse((HttpServletResponse) response);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
