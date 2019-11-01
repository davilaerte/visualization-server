package com.example.visualization.builders;

import com.example.visualization.util.Util;

public class ClassImplBuilder {
	
	private String implClassName;
	private String interfaceName;
	private String implPackageName;
	
	public ClassImplBuilder(String implClassName, String interfaceName, String implPackageName) {
		this.implClassName = implClassName;
		this.interfaceName = interfaceName;
		this.implPackageName = implPackageName;
	}
	
	public String buildImpl() {
		return buildClassName() + "}";
	}
	
	public String buildClassName() {
		String packpageName = Util.isValidString(this.implPackageName) ?
							  "package " + this.implPackageName + "; ":"";
		String className = "public class " + this.implClassName + " ";
		String classInterface = Util.isValidString(this.interfaceName) ?
								"implements " + this.interfaceName + " ":"";
		return packpageName + className + classInterface + "{" + System.lineSeparator();
	}
	
	public String getImplClassName() {
		return this.implClassName;
	}
}
