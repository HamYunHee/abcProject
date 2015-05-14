package com.shshop.filter;

//Import required java libraries
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Implements Filter class
public class LogFilter implements Filter 
{
	public void init(FilterConfig config) throws ServletException 
	{
		String testParam = config.getInitParameter("test-param");
 
		System.out.println("Test Param: " + testParam);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws java.io.IOException, ServletException 
	{
		String ipAddress = request.getRemoteAddr();
		System.out.println("IP " + ipAddress + ", Time " + new Date().toString());

		// Request 를 다른 필터로 던진다.
		chain.doFilter(request, response);
	}

	public void destroy() 
	{

	}
}
