package com.modern.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	UserDetailsService userDetailsService() {
		return new ModernUserDetailsService();
	}
 
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(PasswordEncoder());
		
		return authProvider;
		
	}
	
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
 
@Bean
SecurityFilterChain configureHttp(HttpSecurity http) throws Exception {
	http.authenticationProvider(authenticationProvider());
            
	        http.authorizeHttpRequests(auth -> auth
	        		.anyRequest().authenticated()
	        )
	        .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll())
                
                .logout(logout -> logout.permitAll())
                		
                .rememberMe(rem -> rem
                		.key("AbcDefgHijKlmnOpqrs_1234567890")
                		.tokenValiditySeconds(60 * 60));
                
	        return http.build();
   }

@Bean
public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
}

}
