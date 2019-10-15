package com.example.visualization.models.errors;

public class ImplError {
	
	private ErrorType errorType;
	private String message;
	private StackTraceElement stackTrace;
	
	public ImplError() {		
	}
	
	public ImplError(ErrorType errorType, String message, StackTraceElement stackTrace) {
		this.errorType = errorType;
		this.message = message;
		this.stackTrace = stackTrace;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StackTraceElement getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(StackTraceElement stackTrace) {
		this.stackTrace = stackTrace;
	}	
}
