package com.hospital.payload.response;

import java.security.Timestamp;

public class ErrorResp {

	private Timestamp timeStamp;
	private String message;
	private int statusCode;

	public ErrorResp() {
		super();
	}

	public ErrorResp(String message) {
		super();
		this.message = message;
		

	}

	

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ErrorResp [message=" + message + ", timeStamp=" + timeStamp + ", statusCode=" + statusCode + "]";
	}

}