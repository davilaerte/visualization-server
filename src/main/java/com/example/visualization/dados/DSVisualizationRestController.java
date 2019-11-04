package com.example.visualization.dados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.visualization.controllers.DSVisualizationController;
import com.example.visualization.models.DSVisualizationFormat;
import com.example.visualization.models.ImplFormat;
import com.example.visualization.models.ImplOptionsFormat;
import com.example.visualization.models.RunImplFormat;

@RestController
@RequestMapping("/datas-structure-impl")
public class DSVisualizationRestController {
	
	@Autowired
	private DSVisualizationController dsVisualizationController; 
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ImplOptionsFormat> createNewDSImpl(@RequestBody ImplFormat impl) throws Exception {
		ImplOptionsFormat options = this.dsVisualizationController.createNewDSImpl(impl);
		return new ResponseEntity<ImplOptionsFormat>(options, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<DSVisualizationFormat> runDSImplMethod(@RequestBody RunImplFormat runOptions) throws Exception {
		DSVisualizationFormat visualizationFormat = this.dsVisualizationController.runDSImpl(runOptions);
		return new ResponseEntity<DSVisualizationFormat>(visualizationFormat, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDSImpl(@RequestBody ImplOptionsFormat options) {
		this.dsVisualizationController.deleteDSImpl(options);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}