package com.example.visualization.models;

public class LinkVisualizationFormat {
	public Integer source;
	public Integer target;
	public boolean left;
	public boolean right;
	
	public LinkVisualizationFormat(Integer source, Integer target) {
		this.source = source;
		this.target = target;
		this.left = false;
		this.right = true;
	}

	@Override
	public String toString() {
		return "LinkVisualizationFormat [source=" + source + ", target=" + target + "]";
	}
}
