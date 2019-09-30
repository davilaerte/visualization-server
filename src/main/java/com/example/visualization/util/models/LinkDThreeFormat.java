package com.example.visualization.util.models;

public class LinkDThreeFormat {
	public Integer source;
	public Integer target;
	public boolean left;
	public boolean right;
	
	public LinkDThreeFormat(Integer source, Integer target) {
		this.source = source;
		this.target = target;
		this.left = false;
		this.right = true;
	}
}
