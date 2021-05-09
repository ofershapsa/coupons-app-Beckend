package com.CouponManagment.CouponManagment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CouponManagment.CouponManagment.config.JwtTokenUtil;
import com.CouponManagment.CouponManagment.model.JwtRequest;
import com.CouponManagment.CouponManagment.model.JwtResponse;
import com.CouponManagment.CouponManagment.serviceForJWT.JwtUserDetailsService;


@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		String type = authenticationRequest.getType().toString();
		String start = "[ROLE_";
		type = start.concat(type);
		type = type.concat("]");
		System.out.println(type);
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
         System.out.println(userDetails.getAuthorities().toString());
         if(userDetails.getAuthorities().toString().equals(type)) {
        	 final String token = jwtTokenUtil.generateToken(userDetails);
        	 JwtResponse jrs = new JwtResponse(token);
        	 return ResponseEntity.ok(jrs);
        	 
         }
         
         return ResponseEntity.badRequest().build();
               
}

	

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
