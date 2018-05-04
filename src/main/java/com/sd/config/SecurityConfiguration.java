/**
 * 
 */
package com.sd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author sreesdas
 *
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// Authentication : User --> Roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER").and().withUser("admin")
				.password("{noop}password").roles("USER", "ADMIN");

	}

	// Authorization : Role -> Access
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/api/swagger/**").hasRole("USER").antMatchers("*/**")
				.hasRole("ADMIN").and().csrf().disable().headers().frameOptions().disable();
	}

}
