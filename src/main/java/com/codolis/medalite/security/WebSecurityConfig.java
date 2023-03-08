package com.codolis.medalite.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity(debug=true)
public class WebSecurityConfig {

	@Autowired
		private AuthenticationConfiguration authenticationConfiguration;
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
    UserDetailsService userDetailsService() {
        return new DoctorUserDetailsService();
    }
	
	@Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    MyDaoAuthenticationProvider authenticationProvider() {
        
		MyDaoAuthenticationProvider authProvider = new MyDaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
	
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    
  /*  @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/swagger-ui/**", "/docs/**", "/v3/api-docs");
    }*/
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    	CustomLoginFilter loginFilter = new CustomLoginFilter();
    	loginFilter.setAuthenticationManager(authenticationConfiguration.getAuthenticationManager());
    	
    	
    	http.csrf().disable(); //promeni ovo i includuj token na kraju
    	
        http.addFilterAt(loginFilter, UsernamePasswordAuthenticationFilter.class);
   
        http.authorizeHttpRequests()
        	.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
        	.requestMatchers("/docs/**").permitAll()
        	.requestMatchers("/swagger-ui/**").permitAll()
        	.requestMatchers("/v3/api-docs").permitAll()
        	.requestMatchers("/hello1").permitAll()
        	.requestMatchers("/login").permitAll()
        	.requestMatchers("/logout").permitAll()
        	.requestMatchers("/").permitAll()
        	.anyRequest().authenticated();
        	

        return http.build();
    }

}
