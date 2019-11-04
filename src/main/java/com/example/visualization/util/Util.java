package com.example.visualization.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.example.visualization.impl.models.DoubleLinkedListNode;
import com.example.visualization.impl.models.LinkedListNode;
import com.example.visualization.models.DSVisualizationFormat;
import com.example.visualization.models.LinkVisualizationFormat;
import com.example.visualization.models.NodeVisualizationFormat;

public class Util {
	
	public static final String LABEL_NEXT = "next";
	public static final String LABEL_PREV = "prev";
	public static final String LABEL_HEAD = "HEAD";
	public static final String LABEL_TAIL = "TAIL";
	
	public static String processCode(String code) {
		String processedCode = code.toString()
								   .replace("\\\"", "\"")
								   .replace("\\n", "")
								   .replace("\\t", "");
		return processedCode;
	}
	
	public static boolean isValidString(String string) {
		return string != null && !string.isEmpty();
	}
	
	public static DSVisualizationFormat formatLinkedList(LinkedListNode head) {
		DSVisualizationFormat formatedLinkedList = new DSVisualizationFormat();
		
		Map<LinkedListNode, Integer> visitedNodes = new HashMap<LinkedListNode, Integer>();
		LinkedList<LinkedListNode> queue = new LinkedList<LinkedListNode>();
		
		if (head != null) {
			queue.addLast(head);
			Integer counterId = 1;
			visitedNodes.put(head, counterId);
			while(!queue.isEmpty()) {
				LinkedListNode currNode = queue.removeFirst();	
				Integer currNodeId = visitedNodes.get(currNode);
				formatedLinkedList.nodes.add(new NodeVisualizationFormat(currNodeId, String.valueOf(currNode.data)));
				
				if (currNode.next != null) {
					if (!visitedNodes.containsKey(currNode.next)) {
						queue.addLast(currNode.next);
						visitedNodes.put(currNode.next, ++counterId);
					}
					formatedLinkedList.links.add(new LinkVisualizationFormat(currNodeId, visitedNodes.get(currNode.next), LABEL_NEXT));
				}
			}
		}
		
		
		setLinkedNodeLabels(formatedLinkedList.nodes);
		
		return formatedLinkedList;
	}
	
	public static DSVisualizationFormat formatDoubleLinkedList(DoubleLinkedListNode head, DoubleLinkedListNode last) {
		DSVisualizationFormat formatedDoubleLinkedList = new DSVisualizationFormat();
		
		Map<DoubleLinkedListNode, Integer> visitedNodes = new HashMap<DoubleLinkedListNode, Integer>();
		LinkedList<DoubleLinkedListNode> queue = new LinkedList<DoubleLinkedListNode>();
		Integer counterId = 0;
		
		if (head != null) {
			queue.addLast(head);
			visitedNodes.put(head, ++counterId);
			while(!queue.isEmpty()) {
				DoubleLinkedListNode currNode = queue.removeFirst();
				Integer currNodeId = visitedNodes.get(currNode);
				NodeVisualizationFormat nodeVisualization = new NodeVisualizationFormat(currNodeId, String.valueOf(currNode.data)); 
				setDoubleLinkedNodeLabels(currNode, nodeVisualization, head, last);
				formatedDoubleLinkedList.nodes.add(nodeVisualization);
				
				if (currNode.previous != null) {
					if (!visitedNodes.containsKey(currNode.previous)) {
						queue.addLast(currNode.previous);
						visitedNodes.put(currNode.previous, ++counterId);
					}
					formatedDoubleLinkedList.links.add(new LinkVisualizationFormat(currNodeId, visitedNodes.get(currNode.previous), LABEL_PREV));
				}
				
				if (currNode.next != null) {
					if (!visitedNodes.containsKey(currNode.next)) {
						queue.addLast(currNode.next);
						visitedNodes.put(currNode.next, ++counterId);
					}
					formatedDoubleLinkedList.links.add(new LinkVisualizationFormat(currNodeId, visitedNodes.get(currNode.next), LABEL_NEXT));
				}
			}
		}
		
		if (last != null && !visitedNodes.containsKey(last)) {
			queue.addLast(last);
			visitedNodes.put(last, ++counterId);
			while(!queue.isEmpty()) {
				DoubleLinkedListNode currNode = queue.removeFirst();	
				Integer currNodeId = visitedNodes.get(currNode);
				NodeVisualizationFormat nodeVisualization = new NodeVisualizationFormat(currNodeId, String.valueOf(currNode.data));
				setDoubleLinkedNodeLabels(currNode, nodeVisualization, head, last);
				formatedDoubleLinkedList.nodes.add(nodeVisualization);
				
				if (currNode.previous != null) {
					if (!visitedNodes.containsKey(currNode.previous)) {
						queue.addLast(currNode.previous);
						visitedNodes.put(currNode.previous, ++counterId);
					}
					formatedDoubleLinkedList.links.add(new LinkVisualizationFormat(currNodeId, visitedNodes.get(currNode.previous), LABEL_PREV));
				}
				
				if (currNode.next != null) {
					if (!visitedNodes.containsKey(currNode.next)) {
						queue.addLast(currNode.next);
						visitedNodes.put(currNode.next, ++counterId);
					}
					formatedDoubleLinkedList.links.add(new LinkVisualizationFormat(currNodeId, visitedNodes.get(currNode.next), LABEL_NEXT));
				}
			}
		}
		
		return formatedDoubleLinkedList;
	}
	
	public static void setLinkedNodeLabels(List<NodeVisualizationFormat> nodes) {
		if(nodes.size() == 1) {
			nodes.get(0).setLabel(LABEL_HEAD + "/" + LABEL_TAIL);
		} else if(nodes.size() > 1) {
			nodes.get(0).setLabel(LABEL_HEAD);
			nodes.get(nodes.size() - 1).setLabel(LABEL_TAIL);
		}
	}
	
	public static void setDoubleLinkedNodeLabels(DoubleLinkedListNode currNode, NodeVisualizationFormat nodeVisualization, DoubleLinkedListNode head, DoubleLinkedListNode last) {
		if (currNode.equals(head) && currNode.equals(last)) {
			nodeVisualization.setLabel(LABEL_HEAD + "/" + LABEL_TAIL);
		} else if (currNode.equals(head)) {
			nodeVisualization.setLabel(LABEL_HEAD);
		} else if (currNode.equals(last)) {
			nodeVisualization.setLabel(LABEL_TAIL);
		}
	}
}
