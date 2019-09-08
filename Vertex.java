/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MahmoudChhade_AbbasNajem_I3341_Project;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Mahmoud
 * @author Abbas
 */
public class Vertex implements Comparable<Vertex>{
    public final String name;
	public ArrayList<Edge> neighbours;
	public LinkedList<Vertex> path;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;
	public int compareTo(Vertex other){
		return Double.compare(minDistance,other.minDistance);		
	}
	public Vertex(String name){
		this.name = name;
		neighbours = new ArrayList<Edge>();
		path = new LinkedList<Vertex>();
	}
	public String toString(){
		return name;
	}	
}
