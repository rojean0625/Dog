package com.rojean.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RojeanServlet extends HttpServlet{
	
	 private int message = 0;
	
	 public void init() throws ServletException{
		  System.out.println("rojean servlet ini.");
	      message = message + 1;
	  }

	  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		  Cookie[] ck = request.getCookies();
		  // 设置响应内容类型
	      response.setContentType("text/html");
	      // 实际的逻辑是在这里
	      PrintWriter out = response.getWriter();
	      for(Cookie v:ck) {
	    	  out.println("<h1>" +v.getName() + " " + v.getPath() + " "+ v.getValue() + "</h1>");
	      }
	  }
	  public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
	      // 设置响应内容类型
	      response.setContentType("text/html");
	      // 实际的逻辑是在这里
	      PrintWriter out = response.getWriter();
	      out.println("<h1>" + message + "</h1>");
	  }
	  
	  public void destroy()
	  {
	      System.out.println("rojean servlet destroy");
	  }
}
