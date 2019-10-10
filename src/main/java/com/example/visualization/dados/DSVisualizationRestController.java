package com.example.visualization.dados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.visualization.controllers.DSVisualizationController;
import com.example.visualization.models.ImplFormat;

@RestController
@RequestMapping("/DataStructureImpl")
public class DSVisualizationRestController {
	
	@Autowired
	private DSVisualizationController dsVisualizationController; 
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createNewDSImpl(@RequestBody ImplFormat impl) {
		this.dsVisualizationController.createNewDSImpl(impl);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> runDSImplMethod() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteDSImpl() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
