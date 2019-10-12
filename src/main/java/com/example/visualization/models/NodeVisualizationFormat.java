package com.example.visualization.models;

public class NodeVisualizationFormat {
	public Integer id;
	public String name;
	
	public NodeVisualizationFormat(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "NodeVisualizationFormat [id=" + id + ", name=" + name + "]";
	}
}
