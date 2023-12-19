package com.hospital.exceptions.handler;

public class NurseNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public NurseNotFoundException(String message) {
		super(message);
	}
 
}
