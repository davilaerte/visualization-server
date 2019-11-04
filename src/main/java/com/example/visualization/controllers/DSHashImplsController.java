package com.example.visualization.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.example.visualization.exceptions.RunImplErrorException;
import com.example.visualization.exceptions.TimeoutRunMethodException;
import com.example.visualization.impl.models.IDoubleLinkedList;
import com.example.visualization.impl.models.ILinkedList;
import com.example.visualization.models.DSVisualizationFormat;
import com.example.visualization.models.ImplOptionsFormat;
import com.example.visualization.models.NameImplMethod;
import com.example.visualization.models.RunImplFormat;
import com.example.visualization.models.TiposImpl;
import com.example.visualization.util.RunMethod;
import com.example.visualization.util.Util;

public class DSHashImplsController {
	
	private Map<String, ILinkedList> linkedListImpls;
	private Map<String, IDoubleLinkedList> doubleLinkedListImpls;
	
	public DSHashImplsController() {
		this.linkedListImpls = new HashMap<String, ILinkedList>();
		this.doubleLinkedListImpls = new HashMap<String, IDoubleLinkedList>();
	}
	
	public ImplOptionsFormat saveImpl(TiposImpl tipo, String id, Class<?> implClass) throws InstantiationException, IllegalAccessException {
		if (tipo.equals(TiposImpl.LINKED_LIST)) {
			@SuppressWarnings("deprecation")
			ILinkedList newLinkedListImpl = (ILinkedList)implClass.newInstance();
			this.linkedListImpls.put(id, newLinkedListImpl);
		} else {
			@SuppressWarnings("deprecation")
			IDoubleLinkedList newDoubleLinkedListImpl = (IDoubleLinkedList)implClass.newInstance();
			this.doubleLinkedListImpls.put(id, newDoubleLinkedListImpl);
		}
		
		return new ImplOptionsFormat(tipo, id);
	}
	
	public DSVisualizationFormat runImplMethod(RunImplFormat runOptions) throws RunImplErrorException, TimeoutRunMethodException {
		DSVisualizationFormat dsFormat = null;
		ImplOptionsFormat options = runOptions.getOptions();
		
		if (options.getTipo().equals(TiposImpl.LINKED_LIST)) {
			ILinkedList linkedListImpl = this.linkedListImpls.get(options.getId());
			if (linkedListImpl != null) {
				try {					
					RunMethod linkedListmethod = new RunMethod(() -> {
						runLinkedListMethod(linkedListImpl, runOptions.getNameMethod(), runOptions.getElement());
					});					
					linkedListmethod.execute();
				} catch(TimeoutException e) {
					throw new TimeoutRunMethodException(runOptions.getNameMethod());
				} catch (Exception e) {
					throw new RunImplErrorException(e.getCause());
				}
				dsFormat = Util.formatLinkedList(linkedListImpl.getHead());
			}
		} else {
			IDoubleLinkedList doubleLinkedListImpl = this.doubleLinkedListImpls.get(options.getId());
			if (doubleLinkedListImpl != null) {
				try {
					RunMethod doubleLinkedListmethod = new RunMethod(() -> {
						runDoubleLinkedListMethod(doubleLinkedListImpl, runOptions.getNameMethod(), runOptions.getElement());
					});					
					doubleLinkedListmethod.execute();
				} catch(TimeoutException e) {
					throw new TimeoutRunMethodException(runOptions.getNameMethod());
				} catch (Exception e) {
					throw new RunImplErrorException(e);
				}
				dsFormat = Util.formatDoubleLinkedList(doubleLinkedListImpl.getHead(), doubleLinkedListImpl.getLast());
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
	
	private void runLinkedListMethod(ILinkedList linkedListImpl, NameImplMethod method, Integer element) {
		if (method.equals(NameImplMethod.INSERT)) {
			linkedListImpl.insert(element);
		} else if (method.equals(NameImplMethod.REMOVE)) {
			linkedListImpl.remove(element);
		}
	}
	
	private void runDoubleLinkedListMethod(IDoubleLinkedList doubleLinkedListImpl, NameImplMethod method, Integer element) {
		if (method.equals(NameImplMethod.INSERT)) {
			doubleLinkedListImpl.insert(element);
		} else if (method.equals(NameImplMethod.REMOVE)) {
			doubleLinkedListImpl.remove(element);
		} else if (method.equals(NameImplMethod.INSERT_FIRST)) {
			doubleLinkedListImpl.insertFirst(element);
		} else if (method.equals(NameImplMethod.REMOVE_FIRST)) {
			doubleLinkedListImpl.removeFirst();
		} else if (method.equals(NameImplMethod.REMOVE_LAST)) {
			doubleLinkedListImpl.removeLast();
		}
	}
}
