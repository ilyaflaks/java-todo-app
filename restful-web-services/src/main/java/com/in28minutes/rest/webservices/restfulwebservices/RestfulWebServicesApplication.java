package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
		System.out.println("Application runing on port 5000");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // enable for everything
						.allowedMethods("*") // GET, POST, PATCH, UPDATE, DELETE, etc
						// .allowedOrigins("http://localhost:3000/");
						// .allowedOrigins("*");// Not recommended for production
						.allowedOrigins("http://todoapp-ilyaflaks.s3-website-us-west-1.amazonaws.com/");
			}

		};
	}
}
//http://todoapp-ilyaflaks.s3-website-us-west-1.amazonaws.com/