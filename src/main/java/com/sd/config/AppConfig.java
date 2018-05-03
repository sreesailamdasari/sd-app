package com.sd.config;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//import org.springframework.context.annotation.Configuration;
/*@EnableAutoConfiguration
@Configuration*/
//or
@SpringBootApplication
@ComponentScan(basePackages = "com.sd")
public class AppConfig extends SpringBootServletInitializer {

	/**
	 * 
	 * 
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AppConfig.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}
}