package com.formation.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.formation.service.config.ServiceConfig;

public class RestWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ServiceConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/service/*" };
	}

}
