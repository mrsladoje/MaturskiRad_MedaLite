package com.codolis.medalite.security;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLoginFilter extends AbstractAuthenticationProcessingFilter {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	public CustomLoginFilter() {
		super(new AntPathRequestMatcher("/login", "POST"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException, AuthenticationException, ServletException  {

			UsernameAndPassword usernameAndPassword = getUserNameAndPassword(request);
	        String username = usernameAndPassword.getUsername();
	        String password = usernameAndPassword.getPassword();
	        

	        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
	        SecurityContextHolder.getContext().setAuthentication(authRequest);

	        return this.getAuthenticationManager().authenticate(authRequest);
	}
	
	 private UsernameAndPassword getUserNameAndPassword(HttpServletRequest request) throws IOException {
        String body = request.getReader().lines().collect(Collectors.joining());
        UsernameAndPassword usernameAndPassword = objectMapper.readValue(body, UsernameAndPassword.class);
        return usernameAndPassword;
    }
	
	
}
