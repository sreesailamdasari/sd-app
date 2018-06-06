package com.sd.config;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//import org.springframework.context.annotation.Configuration;
/*@EnableAutoConfiguration
@Configuration*/
//or
@SpringBootApplication
@EnableBatchProcessing
@ComponentScan(basePackages = "com.sd")
public class AppConfig {// extends SpringBootServletInitializer {

	private static final Logger LOGGER = LogManager.getLogger(AppConfig.class);

	/**
	 * 
	 * 
	 */
	// @Override
	// protected SpringApplicationBuilder configure(SpringApplicationBuilder
	// builder) {
	// return builder.sources(AppConfig.class);
	// }

	public static void main(String[] args) {
		LOGGER.info("Checking the log4j from main class file");
		SpringApplication.run(AppConfig.class, args);
	}
}