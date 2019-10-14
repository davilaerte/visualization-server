package com.example.visualization.exceptions;

public class CompilationErrorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CompilationErrorException() {
		super();
	}
	
	public CompilationErrorException(String message) {
		super(message);
	}
}
