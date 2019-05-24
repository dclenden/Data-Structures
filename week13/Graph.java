/*
* @author David W. Clendenning Jr.
*/
package week13;

//Java Program to demonstrate adjacency list  
//representation of graphs 
//https://www.geeksforgeeks.org/graph-and-its-representations/

import java.util.LinkedList; 

//A user define class to represent a graph. 
//A graph is an array of adjacency lists. 
//Size of array will be V (number of vertices  
//in graph) 
class Graph 
{ 
	private int numVertices; 
	private LinkedList<Integer> adjListArray[]; 

	// constructor  
	Graph(int size) 
	{ 
		this.numVertices = size; 

		// define the size of array as  
		// number of vertices 
		adjListArray = new LinkedList[size]; 

		// Create a new list for each vertex 
		// such that adjacent nodes can be stored 
		for(int i = 0; i < size ; i++){ 
			adjListArray[i] = new LinkedList<>(); 
		} 
	} 


	// Adds an edge to an undirected graph 
	void addEdge(int src, int dest) 
	{ 
		// Add an edge from src to dest.  
		adjListArray[src].add(dest); 

		// Since graph is undirected, add an edge from dest 
		// to src also 
		adjListArray[dest].add(src); 
	} 

	// A utility function to print the adjacency list  
	// representation of graph 
	void printGraph() 
	{        
		for(int v = 0; v < numVertices; v++) 
		{ 
			System.out.println("Adjacency list of vertex "+ v); 
			System.out.print("head"); 
			for(Integer pCrawl: adjListArray[v]){ 
				System.out.print(" -> "+pCrawl); 
			} 
			System.out.println("\n"); 
		} 
	} 
}

//This code is contributed by Sumit Ghosh 