package com.hospital.exceptions.handler;

public class ProcedureNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProcedureNotFoundException(String msg) {
		super(msg);
	}
}

