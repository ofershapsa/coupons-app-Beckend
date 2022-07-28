package com.CouponManagment.CouponManagment.modelForJWT;
import java.io.Serializable;

import com.CouponManagment.CouponManagment.services.ClientType;

public class JwtRequest  implements Serializable{

	private String username;
	private String password;
	private ClientType type;
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	public JwtRequest(String username, String password,ClientType type) {
		this.setUsername(username);
		this.setPassword(password);
		this.setType(type);
	}
	
	public ClientType getType() {
		return type;
	}

	public void setType(ClientType type) {
		this.type = type;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
