/*
* @author David W. Clendenning Jr.
*/
package finalproject;

/**
 * @author Delaware Technical Community College
 * 
 * Starter Code for Assignment 10
 * 
 * Modified from:
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 * 
 * Java Program to demonstrate adjacency list  
 * representation of graphs 
 * This code is contributed by Sumit Ghosh 
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List; 

class AirportsGraph 
{ 
	private int numVertices; 
	private LinkedList<Integer> adjListArray[]; 
	//A list of lists to keep track of each path then compare path lengths at a later time
	private ArrayList<List<Integer>> paths;

	/* We will save all the aiports in the graph into a HashMap, which will
	 *   be used to map each airport to a corresponding int, so that we can
	 *   re-use existing code/algorithms written for a graph of integers.
	 */  
	private HashMap<String, Integer> airportsHashMap = new HashMap<>();


	// constructor
	AirportsGraph(ArrayList<String> airportList) { 
		this.numVertices = airportList.size(); 

		// define the size of array as  
		// number of vertices 
		adjListArray = new LinkedList[numVertices]; 

		// Create a new list for each vertex 
		// such that adjacent nodes can be stored 
		for(int i = 0; i < numVertices ; i++){ 
			adjListArray[i] = new LinkedList<>();

			// Initialize the HashMap, which will hold key value pairs
			// corresponding to airport code and an integer.
			// The integer is meaningless - it is only used internally
			// to represent the airport in the graph implementation
			// and any corresponding algorithms.
			airportsHashMap.put(airportList.get(i), i);
		} 
	} 
	/*
	 * This method is a simple "converter," so that the addEdge method
	 * can be called using more human readable airport code, which are
	 * strings, rather than integers.
	 */
	void addRoute(String src, String dest) {
		// TODO: Code to call the private helper method addEdge
		int source = airportsHashMap.get(src);
		int destination = airportsHashMap.get(dest);
		addEdge(source, destination);
	}


	/*
	 * The add edge method has been modified to be private, so it can be used
	 * by the addRoute public method, which takes String arguments instead of
	 * integer arguments.
	 */

	// Adds an edge to an undirected graph 
	private void addEdge(int src, int dest) 
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
		/*
		 * This method has been modified to utilize the airportFromInt helper method
		 * below, so that the adjacency list, which holds integers representing
		 * airports, can be displayed in a more readable form.
		 */
		System.out.println("\nPrinting whole graph as adjacency list: ");
		for(int v = 0; v < numVertices; v++) 
		{ 
			System.out.println(airportFromInt(v) + "-->"); 
			for(Integer pCrawl: adjListArray[v]){ 
				System.out.print(airportFromInt(pCrawl) + "\t"); 
			} 
			System.out.println("\n"); 
		} 
	}

	/*
	 * This method will facilitate doing a reverse look up from
	 * the HashMap object.  Since the HashMap has a String key and
	 * integer value, we can't look things up by the value.
	 */
	private String airportFromInt(int airportInt) {
		// TODO: Write body of airportFromInt method
		for(String pKey: airportsHashMap.keySet()) {
			if(airportsHashMap.get(pKey).equals(airportInt)) {
				return pKey;
			}
		}
		return null;
	}
	//method takes a key parameter and prints all airports that are connected or "adjacent" to it
	public void printAdjacent(String key) {
		System.out.println("Adjacency list of airport " + key); 
		for(Integer pCrawl: adjListArray[airportsHashMap.get(key)]){ 
			System.out.print(airportFromInt(pCrawl) + "\t"); 
		} 
		System.out.println("\n"); 
	} 
	
	public void printAllPaths(String s, String d)  
    { 
        boolean[] isVisited = new boolean[numVertices]; 
        ArrayList<Integer> pathList = new ArrayList<>(); 
          
        //add source to path[] 
        pathList.add(airportsHashMap.get(s)); 
        System.out.println("\nAll paths between " + s + " and " + d + "\n");
        //Call recursive utility 
        printAllPathsUtil(airportsHashMap.get(s), airportsHashMap.get(d), isVisited, pathList); 
    } 
	
	@SuppressWarnings("unchecked")
	public void printShortestPath(String s, String d) {
		 boolean[] isVisited = new boolean[numVertices]; 
	        ArrayList<Integer> pathList = new ArrayList<>(); 
	        ArrayList<List<Integer>> path = new ArrayList<>();
	        paths = new ArrayList<>();
	          
	        //add source to path[] 
	        pathList.add(airportsHashMap.get(s)); 
	        System.out.println("\nShortest path between " + s + " and " + d);
	        //Call recursive utility 
	        printShortestPathUtil(airportsHashMap.get(s), airportsHashMap.get(d), isVisited, pathList); 
	        //System.out.println(paths);
	        List<Integer> shortPath = paths.get(0);
	        Iterator<List<Integer>> it = paths.iterator();
	        while(it.hasNext()) {
	        	if(((List<Integer>) it.next()).size() < shortPath.size()) {
	        		shortPath = (List<Integer>) it.next();
	        	}
	        }
	        for(Integer sPath : shortPath) {
	        	System.out.print(airportFromInt(sPath) + "\t");
	        }
	        System.out.println();
//	        int size = paths.get(0).size();
//	        List<Integer> p = new ArrayList<>();
//	        for(List<Integer> path : paths) {
//	        	if(path.size() < size) {
//	        		size = path.size();
//	        		p = path;
//	        	}
//	        }
	        //System.out.println(paths.get(0));
	        
	}
	
	@SuppressWarnings("unused")
	private void printShortestPathUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) { 
		// Mark the current node 
        isVisited[u] = true; 
        if (u.equals(d))  
        { 
        	//System.out.println("\nPath: ");
//        	for(Integer airport: localPathList) {
//        		System.out.print(airportFromInt(airport) + "\t");
//        	}
//        	System.out.println();
            //System.out.println(localPathList); 
            // if match found then no need to traverse more till depth 
        	//System.out.println(path);
        	paths.add(new ArrayList<Integer>(localPathList));
        	//System.out.println(localPathList);
        
        	//System.out.println(shortPath);
            isVisited[u]= false; 
        } 
          
        // Recur for all the vertices 
        // adjacent to current vertex 
        for (Integer i : adjListArray[u])  
        { 
            if (!isVisited[i]) 
            { 
                // store current node  
                // in path[] 
                localPathList.add(i); 
                printShortestPathUtil(i, d, isVisited, localPathList); 
                  
                // remove current node 
                // in path[] 
                localPathList.remove(i); 
            } 
            //paths.add(localPathList);
        } 
     
        // Mark the current node
        //System.out.println(localPathList);
        //System.out.println(localPathList);
        //return localPathList;
	}
  
    // A recursive function to print 
    // all paths from 'u' to 'd'. 
    // isVisited[] keeps track of 
    // vertices in current path. 
    // localPathList<> stores actual 
    // vertices in the current path 
    private void printAllPathsUtil(Integer u, Integer d, 
                                    boolean[] isVisited, 
                            List<Integer> localPathList) { 
          
        // Mark the current node 
        isVisited[u] = true; 
          
        if (u.equals(d))  
        { 
        	//System.out.println("\nPath: ");
        	for(Integer airport: localPathList) {
        		System.out.print(airportFromInt(airport) + "\t");
        	}
        	System.out.println();
        	//System.out.println("\n\n\n" + localPathList + "\n\n\n");
            //System.out.println(localPathList); 
            // if match found then no need to traverse more till depth 
            isVisited[u]= false; 
            return ; 
        } 
          
        // Recur for all the vertices 
        // adjacent to current vertex 
        for (Integer i : adjListArray[u])  
        { 
            if (!isVisited[i]) 
            { 
                // store current node  
                // in path[] 
            	//System.out.println("\n\n\n" + localPathList + "\n\n\n");
                localPathList.add(i); 
                //System.out.println("\n\n\n" + localPathList + "\n\n\n");
                printAllPathsUtil(i, d, isVisited, localPathList); 
                  
                // remove current node 
                // in path[] 
                localPathList.remove(i); 
            } 
        } 
          
        // Mark the current node 
        isVisited[u] = false; 
    }
    
    
    
    
    
		
}
