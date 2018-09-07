package com.formation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.formation.controller.HelloController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = HelloController.class)
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		registry.jsp("/WEB-INF/views/", ".jsp");

	}
}
