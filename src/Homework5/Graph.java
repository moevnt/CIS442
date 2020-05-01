package Homework5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private Map<String, Vertex> vertexMap = new HashMap<>();

	public Graph(){

	}

	public void addEdge(String sourceName, String destName, double cost){
		Vertex source = getVertex(sourceName);
		Vertex dest = getVertex(destName);
		Edge edge = new Edge(dest, cost);

		source.addEdge(edge);

		vertexMap.put((sourceName+" "+destName), source);
		System.out.println();
	}

	private Vertex getVertex(String vertexName){
		Vertex v = vertexMap.get(vertexName);

		if(v == null){
			v = new Vertex(vertexName);
			v.ID = v.getID();
			vertexMap.put(vertexName,v);
		}
		return v;
	}

	private List<Edge> getList(String key){
		return vertexMap.get(key).getAdj();
	}

	public static void main(String[] args){
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");

		Graph graph = new Graph();

		graph.addEdge(a.name,b.name, 10);
		graph.addEdge(a.name,c.name, 5);
		System.out.println();
	}


}


/*
HashMap<String, Integer> map;
integer index = map.get("D");
 */

//a b 10
//b d 5