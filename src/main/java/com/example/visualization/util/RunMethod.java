package com.example.visualization.util;

import java.util.concurrent.TimeoutException;

public class RunMethod {
	
	private static final Integer RUN_TIMEOUT = 10000;
	
	private Thread threadMethod;
	private Throwable error;
	
	public RunMethod(Runnable runnableMethod) {
		this.threadMethod = new Thread(runnableMethod);
	}
	
	@SuppressWarnings("deprecation")
	public void execute() throws Exception {
		this.threadMethod.setUncaughtExceptionHandler((thread, error) -> {
	    	setError(error);
		});
		
		this.threadMethod.start(); //run method
		this.threadMethod.join(RUN_TIMEOUT);//wait until timeout
		
		if (this.threadMethod.isAlive()) { //if thread is alive after timeout, launch exception
			this.threadMethod.stop();
			throw new TimeoutException();
		} else if(this.error != null) {
			throw new Exception(this.error);
		}
	}
	
	public void setError(Throwable error) {
		this.error = error;
	}
}
