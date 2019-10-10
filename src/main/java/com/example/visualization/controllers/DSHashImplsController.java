package com.example.visualization.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.visualization.impl.models.IDoubleLinkedList;
import com.example.visualization.impl.models.ILinkedList;
import com.example.visualization.models.TiposImpl;

public class DSHashImplsController {
	
	private Map<String, ILinkedList> linkedListImpls;
	private Map<String, IDoubleLinkedList> doubleLinkedListImpls;
	
	public DSHashImplsController() {
		this.linkedListImpls = new HashMap<String, ILinkedList>();
		this.doubleLinkedListImpls = new HashMap<String, IDoubleLinkedList>();
	}
	
	public void saveImpl(TiposImpl tipo, String id, Class<?> implClass) throws InstantiationException, IllegalAccessException {
		if (tipo.equals(TiposImpl.LINKED_LIST)) {
			@SuppressWarnings("deprecation")
			ILinkedList newLinkedListImpl = (ILinkedList)implClass.newInstance();
			this.linkedListImpls.put(id, newLinkedListImpl);
		} else {
			@SuppressWarnings("deprecation")
			IDoubleLinkedList newDoubleLinkedListImpl = (IDoubleLinkedList)implClass.newInstance();
			this.doubleLinkedListImpls.put(id, newDoubleLinkedListImpl);
		}
	}
	
	public void removeImpl(TiposImpl tipo, String id) {
		if (tipo.equals(TiposImpl.LINKED_LIST)) {
			this.linkedListImpls.remove(id);
		} else {
			this.doubleLinkedListImpls.remove(id);
		}
	}

}
