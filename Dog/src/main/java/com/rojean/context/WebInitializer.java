package com.rojean.context;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.rojean.servlet.RojeanFilter;
import com.rojean.servlet.RojeanHttpSessionListener;
import com.rojean.servlet.RojeanRequestListener;
import com.rojean.servlet.RojeanServlet;
import com.rojean.servlet.RojeanServletContextListener;




public class WebInitializer  implements WebApplicationInitializer {

	private static final Logger logger = LoggerFactory.getLogger(WebInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		       logger.info("######## WebApplicationInitializer onStartup#########");
		       
				AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
				rootContext.register(SpringRootConfig.class);
				servletContext.addListener(new ContextLoaderListener(rootContext));
				
				//ApplicationContextUtils.setApplicationContext(rootContext);
				//ConfigurableEnvironment environment = rootContext.getEnvironment();

//				CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//				encodingFilter.setEncoding("UTF-8");
//				encodingFilter.setForceEncoding(true);
//				FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", encodingFilter);
//				characterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");

				
				AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
				dispatcherContext.register(SpringMVCConfig.class);
				
				// dispatcherServlet
				ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
				dispatcher.setLoadOnStartup(1);
				dispatcher.addMapping("/");
				
				ServletRegistration.Dynamic rojeanServlet = servletContext.addServlet("rojeanServlet", new RojeanServlet());
				rojeanServlet.addMapping("/rojeanServlet");
				
				servletContext.addListener(new RojeanServletContextListener());
				servletContext.addListener(new RojeanHttpSessionListener());
				servletContext.addListener(new RojeanRequestListener());
				
				FilterRegistration.Dynamic rojeanFilter = servletContext.addFilter("rojeanFilter", new RojeanFilter());
				rojeanFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),true, "/*");
				
				
				
	}
	
	

	


}
