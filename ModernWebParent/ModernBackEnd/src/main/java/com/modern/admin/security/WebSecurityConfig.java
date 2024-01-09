package com.modern.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
 
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
 
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
          .authorizeHttpRequests((authz) -> authz
          .anyRequest().permitAll()
      );
      return http.build();
    }
 
}
