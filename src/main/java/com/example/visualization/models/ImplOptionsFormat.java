package com.example.visualization.models;

public class ImplOptionsFormat {
	
	private TiposImpl tipo;
	private String id;
	
	public ImplOptionsFormat() {
		
	}
	
	public ImplOptionsFormat(TiposImpl tipo, String id) {
		this.tipo = tipo;
		this.id = id;
	}

	public TiposImpl getTipo() {
		return tipo;
	}

	public void setTipo(TiposImpl tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
