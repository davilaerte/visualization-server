package com.example.visualization.models;

import java.util.ArrayList;
import java.util.List;

public class DSImplFormat {
	public List<NodeImplFormat> nodes;
	public List<LinkImplFormat> links;
	
	public DSImplFormat() {
		this.nodes = new ArrayList<>();
		this.links = new ArrayList<>();		
	}
}
