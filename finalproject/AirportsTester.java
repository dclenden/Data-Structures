/*
* @author David W. Clendenning Jr.
*/
package finalproject;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 */
public class AirportsTester {


	public static void main(String args[]) 
	{ 

		ArrayList<String> airportList = new ArrayList<>();
//		airportList.add("LNS");
//		airportList.add("PHL"); //everything commented is test code that was taken directly from the assignments PDF to match outputs
//		airportList.add("CTH");
//		airportList.add("ILG");
		airportList.add("JFK");
		airportList.add("EWR");
		airportList.add("PHL");
		airportList.add("ILG");
		airportList.add("IAD");
		/*airportList.add("JuK");
		airportList.add("EuR");     extra added airports to graph to test
		airportList.add("PuL");
		airportList.add("IuG");
		airportList.add("IuD");*/
		
		AirportsGraph airports = new AirportsGraph(airportList);
        airports.addRoute("JFK", "IAD");
        airports.addRoute("IAD", "ILG");
        airports.addRoute("ILG", "PHL");
        airports.addRoute("IAD", "PHL");
        airports.addRoute("IAD", "EWR");
        airports.addRoute("PHL", "EWR");
        /*airports.addRoute("JuK", "IAD");
        airports.addRoute("IAD", "IuG");     extra added airports to graph to test
        airports.addRoute("ILG", "PuL");
        airports.addRoute("IuD", "PHL");
        airports.addRoute("IAD", "EuR");
        airports.addRoute("PHL", "EuR");*/
        
//		airports.addRoute("LNS", "CTH"); 
//		airports.addRoute("CTH", "PHL"); 
//		airports.addRoute("PHL", "ILG"); 
//		airports.addRoute("PHL", "LNS"); 

		// print the adjacency list representation of  
		// the above graph 
		airports.printGraph(); //

		// TODO: Implement the printAdjacent method, so that it displays all
		// adjacent airports from the given airport passed in
		airports.printAdjacent("PHL");
		airports.printAdjacent("ILG");
		
		airports.printAllPaths("EWR", "PHL");
		airports.printAllPaths("EWR", "ILG");
		
		System.out.println("\n##########################################\nThe following portion is for extra credit:\n\n");
		airports.printShortestPath("EWR", "PHL");
		airports.printShortestPath("EWR", "ILG");
	} 


} 