package Homework5;

import java.util.*;

public class Vertex {

	public String name;
	public List<Edge> adj;
	public int dist;
	public Vertex prev;
	public int ID;
	public double inDegree;
	public int topNumber;

	public Vertex(String name){
		this.name = name;
		adj = new LinkedList<Edge>();
		inDegree=0;
		dist = Integer.MAX_VALUE;
	}

	public void addEdge(Edge edge){
		adj.add(edge);
	}

	public List<Edge> getAdj() {
		return adj;
	}

	public int getID() {
		return ID;
	}

}
