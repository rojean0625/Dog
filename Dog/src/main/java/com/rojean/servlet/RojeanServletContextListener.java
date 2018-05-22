package com.rojean.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class RojeanServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String name = sce.getServletContext().getServletContextName();
		System.out.println("Context Listener:" + name);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context Listener destory");
	}

}
