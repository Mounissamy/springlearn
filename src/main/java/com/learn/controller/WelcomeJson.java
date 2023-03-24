package com.learn.controller;

public class WelcomeJson {
	private String message;
	
	public WelcomeJson() {}
	
	public WelcomeJson(String msg)
	{
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return this.message;
	}

	
}
