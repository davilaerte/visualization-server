package com.example.visualization.builders;

import java.util.Map;

import com.example.visualization.impl.models.ILinkedList;
import com.example.visualization.util.Util;

public class LinkedListImplBuilder extends ClassImplBuilder {
	
	public Map<String, String> implMethods;
	
	public LinkedListImplBuilder(String implClassName, String interfaceName, String implPackageName ,Map<String, String> implMethods) {
		super(implClassName, interfaceName, implPackageName);
		this.implMethods = implMethods;
	}
	
	public LinkedListImplBuilder(String implClassName, String implPackageName ,Map<String, String> implMethods) {
		super(implClassName, ILinkedList.class.getSimpleName(), implPackageName);
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
		return " private LinkedListNode head; ";
	}
	
	public String buildImplInsertMethod() {
		String nameMethod = "insert";
		String bodyMethod = Util.isValidString(implMethods.get(nameMethod)) ?
							Util.processCode(implMethods.get(nameMethod)):"";
		String method = "public void " + nameMethod + "(Integer element) { " + 
							bodyMethod +
						" } ";
		return method;
	}
	
	public String buildImplRemoveMethod() {
		String nameMethod = "remove";
		String bodyMethod = Util.isValidString(implMethods.get(nameMethod)) ?
							Util.processCode(implMethods.get(nameMethod)):"";
		String method = "public void " + nameMethod + "(Integer element) { " + 
							bodyMethod +
						" } ";
		return method;
	}
	
	public String buildDefaultGetHeadMethod() {
		String method = "public LinkedListNode getHead() { " + 
				 			"return this.head;" +
				 		" } ";
		return method;
	}
}
