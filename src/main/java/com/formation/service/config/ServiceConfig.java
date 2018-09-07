package com.formation.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.formation.controller.service.BenderController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { BenderController.class })
public class ServiceConfig implements WebMvcConfigurer {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.enableContentNegotiation(new MappingJackson2JsonView());
	}
}
