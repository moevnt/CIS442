package Homework5;

import java.util.*;

public class Vertex {

	public String name;
	public List<Edge> adj;
	public double dist;
	public Vertex prev;
	public int ID;

	public Vertex(String name){
		this.name = name;
		adj = new LinkedList<Edge>();
	}

	public void addEdge(Edge edge){
		adj.add(edge);
	}

	public List<Edge> getAdj() {
		return adj;
	}

	public void setAdj(List<Edge> adj) {
		this.adj = adj;
	}

	public double getDist() {
		return dist;
	}

	public Vertex getPrev() {
		return prev;
	}

	public void setPrev(Vertex prev) {
		this.prev = prev;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setDist(double dist) {
		this.dist = dist;
	}
}
