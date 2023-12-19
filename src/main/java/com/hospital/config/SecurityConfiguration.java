package com.hospital.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hospital.security.JwtAuthenticationEntryPoint;
import com.hospital.security.JwtAuthenticationFilter;




@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

	@Autowired
	private JwtAuthenticationEntryPoint point;

	@Autowired
	private JwtAuthenticationFilter filter;

	@Autowired
	private AuthenticationProvider authProvider;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.cors().and()
		.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authorize -> authorize
						.antMatchers("/swagger-ui/**").permitAll()
						.antMatchers("/v3/api-docs/**").permitAll()		// swagger configuration
						.antMatchers("/api/**").permitAll()
						.anyRequest().authenticated())
				.authenticationProvider(authProvider)
				.sessionManagement(mng -> mng.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
		


	}
}
