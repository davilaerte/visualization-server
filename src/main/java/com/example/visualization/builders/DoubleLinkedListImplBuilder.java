package com.example.visualization.builders;

import java.util.Map;

import com.example.visualization.helpers.Util;
import com.example.visualization.impl.models.IDoubleLinkedList;

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
			   buildDefaultGetHeadMethod() +
			   buildDefaultGetLastMethod() + "}";
	}
	
	@Override
	public String buildImplAttributes() {
		return " private DoubleLinkedListNode head;" + System.lineSeparator() +
		       " private DoubleLinkedListNode last;" + System.lineSeparator() + System.lineSeparator();
	}
	
	public String buildImplInsertFirstMethod() {
		String nameMethod = "insertFirst";
		String bodyMethod = Util.isValidString(this.implMethods.get(nameMethod)) ?
							Util.processCode(this.implMethods.get(nameMethod)):"";
		String method = " public void " + nameMethod + "(Integer element) { " + System.lineSeparator() + 
							bodyMethod + System.lineSeparator() +
						" } " + System.lineSeparator() + System.lineSeparator();
		return method;
	}
	
	public String buildImplRemoveFirstMethod() {
		String nameMethod = "removeFirst";
		String bodyMethod = Util.isValidString(this.implMethods.get(nameMethod)) ?
							Util.processCode(this.implMethods.get(nameMethod)):"";
		String method = " public void " + nameMethod + "() { " + System.lineSeparator() + 
							bodyMethod + System.lineSeparator() +
						" } " + System.lineSeparator() + System.lineSeparator();
		return method;
	}
	
	public String buildImplRemoveLastMethod() {
		String nameMethod = "removeLast";
		String bodyMethod = Util.isValidString(this.implMethods.get(nameMethod)) ?
							Util.processCode(this.implMethods.get(nameMethod)):"";
		String method = " public void " + nameMethod + "() { " + System.lineSeparator() + 
							bodyMethod + System.lineSeparator() +
						" } " + System.lineSeparator() + System.lineSeparator();
		return method;
	}
	
	@Override
	public String buildDefaultGetHeadMethod() {
		String method = " public DoubleLinkedListNode getHead() { " + System.lineSeparator() + 
				 			"  return this.head;" + System.lineSeparator() +
				 		" } " + System.lineSeparator() + System.lineSeparator();
		return method;
	}
	
	public String buildDefaultGetLastMethod() {
		String method = " public DoubleLinkedListNode getLast() { " + System.lineSeparator() + 
				 			"  return this.last;" + System.lineSeparator() +
				 		" } " + System.lineSeparator();
		return method;
	}
}
