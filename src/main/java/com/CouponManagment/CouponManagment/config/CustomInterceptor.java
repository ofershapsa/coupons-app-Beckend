package com.CouponManagment.CouponManagment.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class CustomInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
String jwt = request.getHeader("Authorization");
//System.out.println(jwt);
Cookie cookie = new Cookie("token", jwt);
 cookie.setHttpOnly(true);
// cookie.setSecure(false);
response.addCookie(cookie);
System.out.println(request.getCookies());
	}
	
	

}

/*	ResponseCookie springCookie = ResponseCookie.from("token", "c2FtLnNtaXRoQGV4YW1wbGUuY29t")
			    .httpOnly(true)
			    .build();
		
		ResponseEntity
	    .ok()
	    .header(HttpHeaders.SET_COOKIE, springCookie.toString())
	    .build();
	
        System.out.println(springCookie);
 */