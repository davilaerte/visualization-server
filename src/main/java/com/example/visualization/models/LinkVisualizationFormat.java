package com.example.visualization.models;

public class LinkVisualizationFormat {
	public Integer source;
	public Integer target;
	public boolean left;
	public boolean right;
	public String label;
	
	public LinkVisualizationFormat(Integer source, Integer target, String label) {
		this.source = source;
		this.target = target;
		this.left = false;
		this.right = true;
		this.label = label;
	}
	
	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "LinkVisualizationFormat [source=" + source + ", target=" + target + ", left=" + left + ", right="
				+ right + ", label=" + label + "]";
	}
}
