package com.hospital.exceptions.handler;

public class TrainedInNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TrainedInNotFoundException(String msg) {
		super(msg);
	}
 
}