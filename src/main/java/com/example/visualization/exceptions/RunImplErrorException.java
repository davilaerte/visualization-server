package com.example.visualization.exceptions;

public class RunImplErrorException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public RunImplErrorException() {
		super();
	}
	
	public RunImplErrorException(Exception e) {
		super(e);
	}
}