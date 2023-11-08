package com.restaurent.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/v1/users/**", "/v1/user/**", "/v1/tableBooking/**", "/swagger-ui/**").permitAll()
				.anyRequest().authenticated();
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("*"); // Allow all origins
		config.addAllowedMethod("*"); // Allow all HTTP methods
		config.addAllowedHeader("*"); // Allow all headers
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	private static final String[] AUTH_WHITELIST = { "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs",
			"/webjars/**" };

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(AUTH_WHITELIST);
	}
}
