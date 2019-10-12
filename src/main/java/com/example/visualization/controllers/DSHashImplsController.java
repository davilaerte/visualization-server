package com.example.visualization.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.visualization.impl.models.IDoubleLinkedList;
import com.example.visualization.impl.models.ILinkedList;
import com.example.visualization.models.DSVisualizationFormat;
import com.example.visualization.models.ImplOptionsFormat;
import com.example.visualization.models.TiposImpl;
import com.example.visualization.util.Util;

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
	
	public DSVisualizationFormat runImplMethod(ImplOptionsFormat options, String nameMethod, Integer element) {
		DSVisualizationFormat dsFormat = null;
		
		if (options.getTipo().equals(TiposImpl.LINKED_LIST)) {
			ILinkedList linkedListImpl = this.linkedListImpls.get(options.getId());
			if (linkedListImpl != null) {
				runLinkedListMethod(linkedListImpl, nameMethod, element);
				dsFormat = Util.formatLinkedList(linkedListImpl.getHead());
			}
		} else {
			IDoubleLinkedList doubleLinkedListImpl = this.doubleLinkedListImpls.get(options.getId());
			if (doubleLinkedListImpl != null) {
				runDoubleLinkedListMethod(doubleLinkedListImpl, nameMethod, element);
				dsFormat = Util.formatDoubleLinkedList(doubleLinkedListImpl.getHead());
			}
		}
		
		return dsFormat;
	}
	
	public void removeImpl(ImplOptionsFormat options) {
		if (options.getTipo().equals(TiposImpl.LINKED_LIST)) {
			this.linkedListImpls.remove(options.getId());
		} else {
			this.doubleLinkedListImpls.remove(options.getId());
		}
	}
	
	private void runLinkedListMethod(ILinkedList linkedListImpl, String method, Integer element) {
		if (method.equals("insert")) {
			linkedListImpl.insert(element);
		} else if (method.equals("remove")) {
			linkedListImpl.remove(element);
		}
	}
	
	private void runDoubleLinkedListMethod(IDoubleLinkedList doubleLinkedListImpl, String method, Integer element) {
		if (method.equals("insert")) {
			doubleLinkedListImpl.insert(element);
		} else if (method.equals("remove")) {
			doubleLinkedListImpl.remove(element);
		} else if (method.equals("insertFirst")) {
			doubleLinkedListImpl.insertFirst(element);
		} else if (method.equals("removeFirst")) {
			doubleLinkedListImpl.removeFirst();
		} else if (method.equals("removeLast")) {
			doubleLinkedListImpl.removeLast();
		}
	}
}
