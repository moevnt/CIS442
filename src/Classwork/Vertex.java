package Classwork;

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

	public int getID() {
		return ID;
	}
}
