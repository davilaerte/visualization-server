package com.example.visualization.dados;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.visualization.impl.models.ILinkedList;
import com.example.visualization.impl.models.LinkedListNode;
import com.example.visualization.models.DSVisualizationFormat;
import com.example.visualization.models.LinkVisualizationFormat;
import com.example.visualization.models.NodeVisualizationFormat;

import net.openhft.compiler.CompilerUtils;

@RestController
@RequestMapping("/visualization")
public class VisualizationRestController {
	
	Integer idCounter = 0;
	Map<String, ILinkedList> eds = new HashMap<String, ILinkedList>();
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> compileAndSaveED(@RequestBody String code) {
		String uniqueID = String.valueOf(++idCounter);
		String rCode = code.toString().substring(1,code.toString().length()-1)
						   .replace("\\\"", "\"")
						   .replace("\\n", "")
						   .replace("\\t", "");
		String nClass = "MyClass" + uniqueID;
		String nCode = rCode.toString().replaceAll("class\\s+\\w+\\s+implements", "class " + nClass + " implements");
		String className = "com.example.visualization.impl.models." + nClass;
		String javaCode = "package com.example.visualization.impl.models;\n" + nCode;
		
		try {
			Class<?> jClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
			@SuppressWarnings("deprecation")
			ILinkedList newED = (ILinkedList.class.cast(jClass.newInstance()));
			eds.put(uniqueID, newED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<String>(uniqueID, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<DSVisualizationFormat> getAdd(@RequestParam("id") String id, @RequestBody String element) {
		ILinkedList ed = eds.get(id);
		ed.insert(Integer.valueOf(element.toString().substring(1,element.toString().length()-1)));
		
		DSVisualizationFormat formatedEd = new DSVisualizationFormat();
		LinkedListNode node = ed.getHead();
		Integer counter = 0;
		while(node != null) {
			NodeVisualizationFormat formatedNode = new NodeVisualizationFormat(counter, String.valueOf(node.data));
			formatedEd.nodes.add(formatedNode);
			if (node.next != null) {
				LinkVisualizationFormat formatedLink = new LinkVisualizationFormat(counter, counter + 1);
				formatedEd.links.add(formatedLink);
			}			
			counter++;
			node = node.next;
		}

		return new ResponseEntity<DSVisualizationFormat>(formatedEd, HttpStatus.OK);
	}
}
