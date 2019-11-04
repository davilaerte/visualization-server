package com.example.visualization.models.errors;

import com.example.visualization.models.NameImplMethod;

public class ImplError {
	
	private ErrorType errorType;
	private String message;
	private NameImplMethod methodName;
	private StackTraceElement stackTrace;
	
	public ImplError() {		
	}
	
	public ImplError(ErrorType errorType, String message, NameImplMethod methodName, StackTraceElement stackTrace) {
		this.errorType = errorType;
		this.message = message;
		this.methodName = methodName;
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

	public NameImplMethod getMethodName() {
		return methodName;
	}

	public void setMethodName(NameImplMethod methodName) {
		this.methodName = methodName;
	}

	public StackTraceElement getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(StackTraceElement stackTrace) {
		this.stackTrace = stackTrace;
	}	
}
