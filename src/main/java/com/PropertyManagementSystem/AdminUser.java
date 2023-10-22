package com.PropertyManagementSystem;

public class AdminUser {
	private String username;
	private String email;
	private String password;
	
	public AdminUser( String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	
}
