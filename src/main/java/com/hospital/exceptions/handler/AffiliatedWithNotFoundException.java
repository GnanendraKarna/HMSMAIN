package com.hospital.exceptions.handler;

public class AffiliatedWithNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AffiliatedWithNotFoundException(String msg) {
		super(msg);
	}
}
