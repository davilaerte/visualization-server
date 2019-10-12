package com.example.visualization.models;

import java.util.Map;

public class ImplFormat {
	
	private ImplOptionsFormat implOptions;
	private Map<String, String> implMethods;
	
	public ImplFormat() {
		
	}
	
	public ImplFormat(ImplOptionsFormat implOptions, Map<String, String> implMethods) {
		this.implOptions = implOptions;
		this.implMethods = implMethods;
	}
	
	public ImplOptionsFormat getImplOptions() {
		return implOptions;
	}

	public void setImplOptions(ImplOptionsFormat implOptions) {
		this.implOptions = implOptions;
	}

	public Map<String, String> getImplMethods() {
		return implMethods;
	}

	public void setImplMethods(Map<String, String> implMethods) {
		this.implMethods = implMethods;
	}	
}
