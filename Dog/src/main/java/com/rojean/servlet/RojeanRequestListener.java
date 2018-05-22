package com.rojean.servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RojeanRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		String name = (String)sre.getServletContext().getAttribute("rojean");
		System.out.println("requestInitialized:" + name);
		
	}

}
