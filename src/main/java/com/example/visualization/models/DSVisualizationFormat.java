package com.example.visualization.models;

import java.util.ArrayList;
import java.util.List;

public class DSVisualizationFormat {
	public List<NodeVisualizationFormat> nodes;
	public List<LinkVisualizationFormat> links;
	
	public DSVisualizationFormat() {
		this.nodes = new ArrayList<>();
		this.links = new ArrayList<>();		
	}
}
