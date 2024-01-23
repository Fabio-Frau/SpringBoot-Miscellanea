package com.fabiofrau.CORS.Setup.Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CorsSetupDemoApplication {

	@Bean
	public WebMvcConfigurer cors() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedOrigins("http://localhost", "http://example.org")
						.allowedMethods("*");
			}
		};
	}

	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception {
		http.cors(); //cors() is deprecated
		return http.build();

	}

	public static void main(String[] args) {
		SpringApplication.run(CorsSetupDemoApplication.class, args);
	}

}
