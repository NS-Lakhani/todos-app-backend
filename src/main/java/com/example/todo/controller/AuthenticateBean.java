package com.example.todo.controller;

public class AuthenticateBean {

	private String message;

	public AuthenticateBean() {
		super();
	}

	public AuthenticateBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
