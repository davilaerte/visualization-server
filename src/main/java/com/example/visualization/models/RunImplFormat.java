package com.example.visualization.models;

public class RunImplFormat {
	
	private ImplOptionsFormat options;
	private NameImplMethod nameMethod;
	private Integer element;
	
	public RunImplFormat() {
	}
	
	public RunImplFormat(ImplOptionsFormat options, NameImplMethod nameMethod, Integer element) {
		this.options = options;
		this.nameMethod = nameMethod;
		this.element = element;
	}

	public ImplOptionsFormat getOptions() {
		return options;
	}

	public void setOptions(ImplOptionsFormat options) {
		this.options = options;
	}

	public NameImplMethod getNameMethod() {
		return nameMethod;
	}

	public void setNameMethod(NameImplMethod nameMethod) {
		this.nameMethod = nameMethod;
	}

	public Integer getElement() {
		return element;
	}

	public void setElement(Integer element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "RunImplFormat [options=" + options + ", nameMethod=" + nameMethod + ", element=" + element + "]";
	}
}
