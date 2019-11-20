package com.example.visualization.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.springframework.stereotype.Controller;

import com.example.visualization.builders.ClassImplBuilder;
import com.example.visualization.builders.DoubleLinkedListImplBuilder;
import com.example.visualization.builders.LinkedListImplBuilder;
import com.example.visualization.exceptions.CompilationImplErrorException;
import com.example.visualization.helpers.IdGenerator;
import com.example.visualization.helpers.Util;
import com.example.visualization.models.DSVisualizationFormat;
import com.example.visualization.models.ImplFormat;
import com.example.visualization.models.ImplOptionsFormat;
import com.example.visualization.models.RunImplFormat;
import com.example.visualization.models.TiposImpl;

import net.openhft.compiler.CompilerUtils;

@Controller
public class DSVisualizationController {
	
	private static final String PACKAGE_PATH = "com.example.visualization.impl.models";
	private static final String NAME_IMPL_CLASS = "DSImpl";
	
	private DSHashImplsController hashImplController;
	private IdGenerator idGenerator;
	
	public DSVisualizationController() {
		this.hashImplController = new DSHashImplsController();
		this.idGenerator = new IdGenerator();
	}
	
	public ImplOptionsFormat createNewDSImpl(ImplFormat impl) throws Exception {
		ImplOptionsFormat implOptions = impl.getImplOptions();		
		String classImplId = Util.isValidString(implOptions.getId()) ? 
							 implOptions.getId():this.idGenerator.generateNewDSId(implOptions.getTipo());
		
		ClassImplBuilder builder = getClassImplBuilder(impl, NAME_IMPL_CLASS + classImplId);
		String classPath = PACKAGE_PATH + "." + builder.getImplClassName();
		
		ClassLoader classLoader = new ClassLoader() { };
		StringWriter outCompilationError = new StringWriter();
		PrintWriter writeError = new PrintWriter(outCompilationError);
		Class<?> implClass;
		try {
			implClass = CompilerUtils.CACHED_COMPILER.loadFromJava(classLoader, classPath, builder.buildImpl(), writeError);
		} finally {
			if (Util.isValidString(outCompilationError.toString())) {
				throw new CompilationImplErrorException(outCompilationError.toString());
			}
		}
		
		return this.hashImplController.saveImpl(implOptions.getTipo(), classImplId, implClass);
	}
	
	public DSVisualizationFormat runDSImpl(RunImplFormat runOptions) throws Exception {
		return this.hashImplController.runImplMethod(runOptions);
	}
	
	public void deleteDSImpl(ImplOptionsFormat options) {
		this.hashImplController.removeImpl(options);
	}
	
	private ClassImplBuilder getClassImplBuilder(ImplFormat impl, String className) {
		ClassImplBuilder builder;
		
		if (impl.getImplOptions().getTipo().equals(TiposImpl.LINKED_LIST)) {
			builder = new LinkedListImplBuilder(className, PACKAGE_PATH, impl.getImplMethods());
		} else {
			builder = new DoubleLinkedListImplBuilder(className, PACKAGE_PATH, impl.getImplMethods());
		}
		
		return builder;
	}
}
