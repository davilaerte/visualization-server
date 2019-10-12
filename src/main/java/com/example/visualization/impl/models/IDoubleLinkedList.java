package com.example.visualization.impl.models;

public interface IDoubleLinkedList {
	
	public void insert(Integer element);
	
	public void remove(Integer element);
	
	public void insertFirst(Integer element);
	
	public void removeFirst();
	
	public void removeLast();
	
	public DoubleLinkedListNode getHead();
}
