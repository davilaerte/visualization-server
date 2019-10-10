package com.example.visualization.controllers;

import org.springframework.stereotype.Controller;

import com.example.visualization.builders.ClassImplBuilder;
import com.example.visualization.builders.DoubleLinkedListImplBuilder;
import com.example.visualization.builders.LinkedListImplBuilder;
import com.example.visualization.models.ImplFormat;
import com.example.visualization.models.TiposImpl;
import com.example.visualization.util.IdGenerator;

import net.openhft.compiler.CompilerUtils;

@Controller
public class DSVisualizationController {
	
	private final String PACKAGE_PATH = "com.example.visualization.impl.models";
	private final String NAME_IMPL_CLASS = "DSImpl";
	
	private DSHashImplsController hashImplController;
	private IdGenerator idGenerator;
	
	public DSVisualizationController() {
		this.hashImplController = new DSHashImplsController();
		this.idGenerator = new IdGenerator();
	}
	
	public void createNewDSImpl(ImplFormat impl) {
		String classImplId = this.idGenerator.generateNewDSId(impl.getTipo());
		String className = NAME_IMPL_CLASS + classImplId;
		String classPath = PACKAGE_PATH + "." + className;
		
		ClassImplBuilder builder = getClassImplBuilder(impl, className);
		
		try {
			Class<?> implClass = CompilerUtils.CACHED_COMPILER.loadFromJava(classPath, builder.buildImpl());
			this.hashImplController.saveImpl(impl.getTipo(), classImplId, implClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runDSImpl() {
		//Obter DS Impl do seu hash
		//Rodar Método
		//Processar Possiveis Erros
		//Processar Saida
	}
	
	public void deleteDSImpl(TiposImpl tipo, String id) {
		this.hashImplController.removeImpl(tipo, id);
	}
	
	private ClassImplBuilder getClassImplBuilder(ImplFormat impl, String className) {
		ClassImplBuilder builder;
		
		if (impl.getTipo().equals(TiposImpl.LINKED_LIST)) {
			builder = new LinkedListImplBuilder(className, PACKAGE_PATH, impl.getImplMethods());
		} else {
			builder = new DoubleLinkedListImplBuilder(className, PACKAGE_PATH, impl.getImplMethods());
		}
		
		return builder;		
	}
}
