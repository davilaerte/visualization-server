package com.example.visualization.util.models;

import java.util.ArrayList;
import java.util.List;

public class EdDThreeFormat {
	public List<NodeDThreeFormat> nodes;
	public List<LinkDThreeFormat> links;
	
	public EdDThreeFormat() {
		this.nodes = new ArrayList<>();
		this.links = new ArrayList<>();		
	}
}
