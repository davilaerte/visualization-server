package com.example.visualization.models;

import java.util.Map;

public class ImplFormat {
	
	private TiposImpl tipo;
	private Map<String, String> implMethods;
	
	public ImplFormat() {
		
	}
	
	public ImplFormat(TiposImpl tipo, Map<String, String> implMethods) {
		this.tipo = tipo;
		this.implMethods = implMethods;
	}

	public TiposImpl getTipo() {
		return tipo;
	}

	public void setTipo(TiposImpl tipo) {
		this.tipo = tipo;
	}

	public Map<String, String> getImplMethods() {
		return implMethods;
	}

	public void setImplMethods(Map<String, String> implMethods) {
		this.implMethods = implMethods;
	}	

}
