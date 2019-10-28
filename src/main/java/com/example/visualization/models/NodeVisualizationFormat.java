package com.example.visualization.models;

public class NodeVisualizationFormat {
	public Integer id;
	public String name;
	public String label;
	
	public NodeVisualizationFormat(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "NodeVisualizationFormat [id=" + id + ", name=" + name + ", label=" + label + "]";
	}
}
