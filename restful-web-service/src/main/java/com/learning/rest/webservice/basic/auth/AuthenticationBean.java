package com.learning.rest.webservice.basic.auth;

public class AuthenticationBean {

	private String message;

	

	public AuthenticationBean(String message) {
		this.message = message;
		
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	

}
