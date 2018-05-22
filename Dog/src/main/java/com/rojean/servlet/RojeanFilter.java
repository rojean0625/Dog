package com.rojean.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RojeanFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("----过滤器初始化----");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("do Filter "  +request.getProtocol() + "  " + request.getParameter("k"));
		//request.getRequestDispatcher("/a.do").forward(request, response);
		chain.doFilter(request, response);
		response.getWriter().print("hahahahaha");
		System.out.println("pass filter");
	}

	@Override
	public void destroy() {
		  System.out.println("----过滤器销毁----");
	}

}
