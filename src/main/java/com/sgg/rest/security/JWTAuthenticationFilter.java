package com.sgg.rest.security;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgg.rest.model.ApplicationUser;
import com.sgg.rest.service.LoginService;

import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.impl.UserImpl;

import static com.sgg.rest.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter{

	private LoginService loginService;

    public JWTAuthenticationFilter(LoginService loginService, AuthenticationSuccessHandler successHandler) {
    	super(new AntPathRequestMatcher("/login", "POST"));
    	this.setAuthenticationSuccessHandler(successHandler);
        this.loginService = loginService;
    }

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
			HttpServletResponse response)
			throws AuthenticationException, IOException {
		ApplicationUser creds = new ObjectMapper()
                .readValue(request.getInputStream(), ApplicationUser.class);
		ApplicationUser userEntity = loginService.Login(creds.getName(), creds.getPassword());
		if (userEntity != null){
			request.setAttribute(CURRENT_USER_REQ, userEntity);
			return new TokenBasedAuthentication(creds.getName());
		}
		throw new AuthenticationException("用户验证失败:" + creds.getName()){{}};
	}

}

