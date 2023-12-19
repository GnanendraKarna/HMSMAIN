package com.hospital.exceptions.handler;

public class AppointmentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AppointmentNotFoundException(String msg) {
		super(msg);
	}
}
