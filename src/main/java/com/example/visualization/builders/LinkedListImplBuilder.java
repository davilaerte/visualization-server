package com.example.visualization.builders;

import java.util.Map;

import com.example.visualization.helpers.Util;
import com.example.visualization.impl.models.ILinkedList;

public class LinkedListImplBuilder extends ClassImplBuilder {
	
	private static final String LINKED_LIST_NAME = "LinkedList";
	
	public Map<String, String> implMethods;
	
	public LinkedListImplBuilder(String implClassName, String interfaceName, String implPackageName ,Map<String, String> implMethods) {
		super(implClassName, interfaceName, implPackageName);
		this.implMethods = implMethods;
	}
	
	public LinkedListImplBuilder(String implClassName, String implPackageName ,Map<String, String> implMethods) {
		super(LINKED_LIST_NAME + implClassName, ILinkedList.class.getSimpleName(), implPackageName);
		this.implMethods = implMethods;
	}
	
	@Override
	public String buildImpl() {
		return buildClassName() + 
			   buildImplAttributes() +
			   buildImplInsertMethod() +
			   buildImplRemoveMethod() + 
			   buildDefaultGetHeadMethod() + "}";
	}
	
	public String buildImplAttributes() {
		return " private LinkedListNode head; " + System.lineSeparator() + System.lineSeparator();
	}
	
	public String buildImplInsertMethod() {
		String nameMethod = "insert";
		String bodyMethod = Util.isValidString(implMethods.get(nameMethod)) ?
							Util.processCode(implMethods.get(nameMethod)):"";
		String method = " public void " + nameMethod + "(Integer element) { " + System.lineSeparator() + 
							bodyMethod + System.lineSeparator() +
						" } " + System.lineSeparator() + System.lineSeparator();
		return method;
	}
	
	public String buildImplRemoveMethod() {
		String nameMethod = "remove";
		String bodyMethod = Util.isValidString(implMethods.get(nameMethod)) ?
							Util.processCode(implMethods.get(nameMethod)):"";
		String method = " public void " + nameMethod + "(Integer element) { " + System.lineSeparator() + 
							bodyMethod + System.lineSeparator() +
						" } " + System.lineSeparator() + System.lineSeparator();
		return method;
	}
	
	public String buildDefaultGetHeadMethod() {
		String method = " public LinkedListNode getHead() { " + System.lineSeparator() + 
				 			"  return this.head;" + System.lineSeparator() +
				 		" } " + System.lineSeparator();
		return method;
	}
}
