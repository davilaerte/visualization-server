package com.example.visualization.impl.models;

public class DoubleLinkedListNode {
	
	public Integer data;
	public DoubleLinkedListNode next;
	public DoubleLinkedListNode previous;
	
	public DoubleLinkedListNode() {
	}
	
	public DoubleLinkedListNode(Integer data, DoubleLinkedListNode next, DoubleLinkedListNode previous) {
		this.data = data;
		this.next = next;
		this.previous = next;
	}
}