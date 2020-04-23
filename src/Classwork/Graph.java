package Classwork;

import java.util.HashMap;
import java.util.Map;

public class Graph {

	private Map<String, Vertex> vertexMap = new HashMap<>();

	public void addEdge(String sourceName, String destName, double cost){

	}

	private Vertex getVertex(String vertexName){
		Vertex v = vertexMap.get(vertexName);

		if(v == null){
			v = new Vertex(vertexName);
			//v.ID = getID();
			vertexMap.put(vertexName,v);
		}

		return v;
	}


}


//a b 10
//b d 5