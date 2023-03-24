package com.learn.controller.exeception;

import java.time.LocalDate;

public class ErrorDetails {

	private String message;
	private LocalDate timestamp;
	private String details;
	public ErrorDetails(String message, LocalDate timestamp, String details) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.details = details;
	}
	public String getMessage() {
		return message;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public String getDetails() {
		return details;
	}

}
