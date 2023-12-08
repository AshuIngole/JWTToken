package com.jwt.example.config;


	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
	import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.example.security.JwtAutenticationFilter;
import com.jwt.example.security.JwtAuthenticationEntryPoint;

	
	@Configuration
	@EnableWebSecurity
	public class securityConfig  {
		 @Autowired
		    private JwtAuthenticationEntryPoint  point;
		   
		 @Autowired
		    private JwtAutenticationFilter filter;

		    @Bean
		    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		    	
		    	//configuration
		    	
		        http.csrf(csrf -> csrf.disable())
		        		.cors(cors -> cors.disable())
		        		.authorizeHttpRequests(
		        				auth->
		        					auth.requestMatchers("/home/**").authenticated()
		        					.requestMatchers("/auth/login").permitAll().anyRequest().authenticated())
		        					.exceptionHandling(ex -> ex.authenticationEntryPoint(point))	
		        					.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		          ;
		          http.addFilterBefore( filter,UsernamePasswordAuthenticationFilter.class);    
		        return http.build();
		    }

		   
			/*
			 * protected void configure(AuthenticationManagerBuilder auth) throws Exception
			 * { UserDetailsService userDetailsService = null;
			 * auth.userDetailsService(userDetailsService); // You may add additional
			 * authentication configuration here }
			 */
		
	}


	

