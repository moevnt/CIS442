package Homework5;

import java.util.*;

public class Graph {

	private static Map<String, Vertex> vertexMap = new HashMap<>();

	public Graph(){

	}

	public int size(){
		return vertexMap.size();
	}

	public void addEdge(String sourceName, String destName, int cost){
		Vertex source = getVertex(sourceName);
		Vertex dest = getVertex(destName);
		Edge edge = new Edge(dest, cost);
		dest.inDegree++;

		source.addEdge(edge);
	}

	public ArrayList<Vertex> topSort() {
		ArrayList<Vertex> q = new ArrayList<>();
		ArrayList<Vertex> ret = new ArrayList<>();
		int pointer=0;
		int counter=0;

		for (String key: vertexMap.keySet()){
			Vertex v = vertexMap.get(key);
			if (v.inDegree == 0)
				q.add(v);
		}

		while(!q.isEmpty()){
			Vertex v = q.remove(pointer);
			v.topNumber = ++counter;

			List<Edge> list = v.getAdj();
			for (int i=0;i<list.size();i++){
				Vertex w = list.get(i).dest;
				if(--w.inDegree == 0 )
					q.add(w);
			}
			ret.add(v);
		}
		if(counter != vertexMap.size())
			System.out.println("CYCLE FOUND");

		return ret;
	}


	public ArrayList<LinkedList<Vertex>> SPP(){
		ArrayList<LinkedList<Vertex>> ret = new ArrayList<>();
		Vertex v = vertexMap.get(0);

		if(!vertexMap.containsValue(v))
			return ret;

		for (int i=0;i<vertexMap.size();i++){
			Vertex dest = vertexMap.get(i);
			ret.add(pathFinder(v, dest));
		}
		return ret;
	}

	private LinkedList<Vertex> pathFinder(Vertex v, Vertex dest){
		LinkedList<Vertex> path = new LinkedList<>();

		if (v.equals(dest))
			path.add(dest);

		else {
			List<Edge> edges = v.adj;
			int sum = 0;
			for (int i = 0; i < edges.size(); i++) {
				Vertex next = edges.get(i).dest;

				if (next.dist > edges.get(i).cost) {
					next.dist = edges.get(i).cost;
					path.addAll(pathFinder(next, dest));
				}
			}
		}
		return path;
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

	public static void main(String[] args){
		Graph graph = new Graph();
		graph.addEdge("A", "B", 5);
		graph.addEdge("A", "C", 3);
		graph.addEdge("C", "D", 2);
		graph.addEdge("B", "C", 10);
		Vertex v = new Vertex("A");


		ArrayList<Vertex> q = graph.topSort();

		ArrayList<LinkedList<Vertex>> out = graph.SPP();

		while(!q.isEmpty()){
			System.out.println(q.remove(0).name);
		}
		System.out.println();

		for (int i=0;i<out.size();i++){
			System.out.println(out.remove(i));
		}

	}
}
