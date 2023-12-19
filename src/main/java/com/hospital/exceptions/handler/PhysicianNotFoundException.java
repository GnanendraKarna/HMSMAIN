package com.hospital.exceptions.handler;


public class PhysicianNotFoundException extends RuntimeException {
   
	private static final long serialVersionUID = 1L;

	public PhysicianNotFoundException(String message) {
        super(message);
    }
 
}
