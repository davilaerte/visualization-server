package com.example.visualization.builders;

import java.util.Map;

import com.example.visualization.impl.models.IDoubleLinkedList;
import com.example.visualization.util.Util;

public class DoubleLinkedListImplBuilder extends LinkedListImplBuilder {
	
	private static final String DOUBLE_LINKED_LIST_NAME = "DoubleLinkedList";
	
	public DoubleLinkedListImplBuilder(String implClassName, String implPackageName ,Map<String, String> implMethods) {
		super(DOUBLE_LINKED_LIST_NAME + implClassName, IDoubleLinkedList.class.getSimpleName(), implPackageName, implMethods);
	}
	
	@Override
	public String buildImpl() {
		return buildClassName() + 
			   buildImplAttributes() +
			   buildImplInsertMethod() +
			   buildImplInsertFirstMethod() +
			   buildImplRemoveMethod() + 
			   buildImplRemoveFirstMethod() +
			   buildImplRemoveLastMethod() +
			   buildDefaultGetHeadMethod() + "}";
	}
	
	@Override
	public String buildImplAttributes() {
		return " private DoubleLinkedListNode head; " + 
			   " private DoubleLinkedListNode last; ";
	}
	
	public String buildImplInsertFirstMethod() {
		String nameMethod = "insertFirst";
		String bodyMethod = Util.isValidString(this.implMethods.get(nameMethod)) ?
							Util.processCode(this.implMethods.get(nameMethod)):"";
		String method = "public void " + nameMethod + "(Integer element) { " + 
							bodyMethod +
						" } ";
		return method;
	}
	
	public String buildImplRemoveFirstMethod() {
		String nameMethod = "removeFirst";
		String bodyMethod = Util.isValidString(this.implMethods.get(nameMethod)) ?
							Util.processCode(this.implMethods.get(nameMethod)):"";
		String method = "public void " + nameMethod + "() { " + 
							bodyMethod +
						" } ";
		return method;
	}
	
	public String buildImplRemoveLastMethod() {
		String nameMethod = "removeLast";
		String bodyMethod = Util.isValidString(this.implMethods.get(nameMethod)) ?
							Util.processCode(this.implMethods.get(nameMethod)):"";
		String method = "public void " + nameMethod + "() { " + 
							bodyMethod +
						" } ";
		return method;
	}
	
	@Override
	public String buildDefaultGetHeadMethod() {
		String method = "public DoubleLinkedListNode getHead() { " + 
				 			"return this.head;" +
				 		" } ";
		return method;
	}
}
