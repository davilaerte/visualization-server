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

import com.example.visualization.models.ILinkedList;
import com.example.visualization.models.Node;
import com.example.visualization.util.models.EdDThreeFormat;
import com.example.visualization.util.models.LinkDThreeFormat;
import com.example.visualization.util.models.NodeDThreeFormat;

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
		String className = "com.example.visualization.models." + nClass;
		String javaCode = "package com.example.visualization.models;\n" + nCode;
		
		System.out.println(javaCode);
		
		try {
			Class<?> jClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
			@SuppressWarnings("deprecation")
			ILinkedList newED = (ILinkedList)jClass.newInstance();
			eds.put(uniqueID, newED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<String>(uniqueID, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<EdDThreeFormat> getAdd(@RequestParam("id") String id, @RequestBody String element) {
		ILinkedList ed = eds.get(id);
		ed.insert(Integer.valueOf(element.toString().substring(1,element.toString().length()-1)));
		
		EdDThreeFormat formatedEd = new EdDThreeFormat();
		Node node = ed.getHead();
		Integer counter = 0;
		while(node != null) {
			NodeDThreeFormat formatedNode = new NodeDThreeFormat(counter, String.valueOf(node.data));
			formatedEd.nodes.add(formatedNode);
			if (node.next != null) {
				LinkDThreeFormat formatedLink = new LinkDThreeFormat(counter, counter + 1);
				formatedEd.links.add(formatedLink);
			}			
			counter++;
			node = node.next;
		}

		return new ResponseEntity<EdDThreeFormat>(formatedEd, HttpStatus.OK);
	}
}
