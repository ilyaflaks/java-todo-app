package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {
	// Filter chain
	// authenticate all requests
	// basic authentication
	// disabling csrf
	// stateless rest api

	// response to preflight request doesn't pass access control check
	// basic auth

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// authenticate all requests

		// might need this later
		// MvcRequestMatcher.Builder mvcMatcherBuilder = new
		// MvcRequestMatcher.Builder(introspector);
		//

		return http.authorizeHttpRequests(
				auth -> auth

						.mvcMatchers("/authenticate").permitAll()

						.mvcMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()

		)
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).csrf()
				.disable().build();

	}
}
