package com.cg.jwt;
import java.io.Serializable;

public class LoginData implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String userId;
	private String password;
	private String role;
	
	//need default constructor for JSON Parsing
	public LoginData()
	{
		
	}

	public LoginData(String userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}

