package com.example.visualization.util;

import com.example.visualization.models.TiposImpl;

public class IdGenerator {
	
	private Integer linkedListIdCounter;
	private Integer doubleLinkedListIdCounter;
	
	public IdGenerator() {
		this.linkedListIdCounter = 0;
		this.doubleLinkedListIdCounter = 0;
	}
	
	public String generateNewDSId(TiposImpl tipo) {
		String newId;
		
		if (tipo.equals(TiposImpl.LINKED_LIST)) {
			newId = String.valueOf(++this.linkedListIdCounter);
		} else {
			newId = String.valueOf(++this.doubleLinkedListIdCounter);
		}
		
		return newId;
	}
	

}
