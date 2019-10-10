package com.example.visualization.models;

public class LinkImplFormat {
	public Integer source;
	public Integer target;
	public boolean left;
	public boolean right;
	
	public LinkImplFormat(Integer source, Integer target) {
		this.source = source;
		this.target = target;
		this.left = false;
		this.right = true;
	}
}
