package com.example.visualization.exceptions;

import com.example.visualization.models.NameImplMethod;

public class TimeoutRunMethodException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_DEFAULT = "O método ultrapassou o tempo permitido para execução, isso pode"
			+ " indicar que o código está desnecessariamente lento ou com algum possivel loop infinito.";
	
	private NameImplMethod method;
	
	public TimeoutRunMethodException(NameImplMethod method) {
		super(MESSAGE_DEFAULT);
		this.method = method;
	}
	
	public TimeoutRunMethodException(String message, NameImplMethod method) {
		super(message);
		this.method = method;
	}

	public NameImplMethod getMethod() {
		return method;
	}

	public void setMethod(NameImplMethod method) {
		this.method = method;
	}
}
