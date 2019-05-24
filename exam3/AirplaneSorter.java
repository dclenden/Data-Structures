/*
* @author David W. Clendenning Jr.
*/
package exam3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Delaware Technical Community College
 * Exam 3 Starter Code
 */
public class AirplaneSorter {
	static Airplane plane1 = new Airplane("AA", 4992, 1);
	static Airplane plane2 = new Airplane("DL", 1345, 2);
	static Airplane plane3 = new Airplane("AA", 4531, 1);
	static Airplane plane4 = new Airplane("DL", 9873, 2);
	static Airplane plane5 = new Airplane("AA", 3414, 3);
	static Airplane plane6 = new Airplane("DL", 2366, 1);
	
	static Airplane airplaneArray[] = {plane1, plane2, plane3, plane4, plane5, plane6};
	
	static Queue<Airplane> runway = new LinkedList<>();
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(airplaneArray));
		//test(); //<- testing method to test priority with other numbers and Airplanes
		sortAirplaneArray();
		//System.out.println(Arrays.toString(airplaneArray));
		addAirplanesToQueue();
		//System.out.println(runway);
		simulate(); // if you want to simulate
//		System.out.println(Arrays.toString(airplaneArray));
//		AirplaneMergeSort.sort(airplaneArray, 0, airplaneArray.length-1);
//		System.out.println(Arrays.toString(airplaneArray));
	}


	public static void simulate() { //simulated the takeoff of planes from a single runway given that all are in working condition
		Scanner input = new Scanner(System.in);
        boolean flag = false;
		while (!runway.isEmpty()) {
			displayRunwayStatus();
			System.out.println("\nPlease enter 1 to takeoff from the runway (by priority)");
			int choice = input.nextInt();
			if(choice == 1) {
				System.out.println(runway.remove() + "is taking off!");
		    }
		}
		System.out.println("\n\nThere are no more planes on the runway");
		input.close();
	}
	 public static void test() {
	    	ArrayList<Airplane> planes = new ArrayList<>();
	   		Collections.addAll(planes, plane1, plane2, plane3, plane4, plane5, plane6);
	   		Collections.shuffle(planes);
	   		for(int j = 0; j < 6; j++) {
	   			int rand = (int) (100 * Math.random()) + 2;
	   			Airplane a = new Airplane(airplaneArray[j].getAirline(), rand*rand, rand);
	   			airplaneArray[j] = a;
	   		}
	    }
	private static void sortAirplaneArray() {
		// TODO Implement method to call a merge sort
		// The merge sort should sort the planes in increasing order of priority (1, 1, 1, 2, 2, 3) (priority 1 is most important)
		AirplaneMergeSort.sort(airplaneArray, 0, airplaneArray.length-1); // calls mergesort on airplanearray, starting from index 0, till end-1
	}
	private static void addAirplanesToQueue() {
		// TODO Implement method to take all planes in the static array airplaneArray and add them into the queue runway
		for(int i = 0; i < airplaneArray.length; i++) { // adds all plane to the runway
			runway.add(airplaneArray[i]);
		}
	}
	
	private static void displayRunwayStatus() {
		// TODO Implement method to show all the airplanes in the runway
		System.out.println("\n\n##### AIR TRAFFIC CONTROL MENU #####"); // displays the runway status
		System.out.println("Runway Status: " + runway);
	}
}