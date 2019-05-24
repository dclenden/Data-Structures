//David W. Clendenning Jr. - Week 7
package week7;

import java.util.ArrayList;
import java.util.Collections;

public class AirportSimulation {
	static LinkedQueue<Airplane> runway1 = new LinkedQueue<>();
	static LinkedQueue<Airplane> runway2 = new LinkedQueue<>();
	
	static Airplane plane1 = new Airplane("AA", 4992);
	static Airplane plane2 = new Airplane("DL", 1345);
	static Airplane plane3 = new Airplane("AA", 4531);
	static Airplane plane4 = new Airplane("DL", 9873);
	static Airplane plane5 = new Airplane("AA", 3414);
	static Airplane plane6 = new Airplane("DL", 2366);

	public static void main(String[] args) {
		// Commnent/uncomment as needed for testing
		
		// Flights only in runway1
		//testCase1();

		// Flights only in runway1
		//estCase2();
	
		// Flights in both runways test 1
		//testCase3();
		
		// Flights in both runways test 2
		//testCase4();
		
		// Flights in both runways, should dispatch runways in such -> 1 , 1 , 2 , 1 , 1 , 2
		//testCase5();
		
		// Automated test cases for random inputs
		test();

		// TODO: Change the following code, so that each runway alternates if there are planes waiting on both runways
		runwayStatus();
		
		simulate();
	}
		// TODO: Extra credit - change the code so that runway 1 has priority and can send two flights at a time
	
	/* created the simulate function that essentially takes a boolean flag to state which runway we are working on 
	 * as well as a priority counter that will allow two planes from runway1 to launch then go to runway2.
	 * flag -> {false = runway1, true = runway2}
	 */
	
	public static void simulate() {
		boolean flag = false;
		int priority = 0;
		while(!runway1.isEmpty() || !runway2.isEmpty()) {
	    	if(flag == false) {
	    		takeOff(runway1);
				if(!runway2.isEmpty()) {
					if(!runway1.isEmpty() && priority != 1) {
						flag = false;
					    priority++;
					}
					else {
						flag = true;
						priority = 0;
					}
				}
				
				else {
					if(!runway2.isEmpty() && runway1.isEmpty()){
						takeOff(runway1);
					}
				}
	    	}
	    	else if(flag == true) {
	    		takeOff(runway2);
				if(!runway1.isEmpty()) {
					flag = false;
				}
				else {
				    if(runway2.isEmpty() && !runway1.isEmpty()){
						takeOff(runway2);
				    }
				}
	    	}
		}
	}
	/* 
	 * Abstracted the takeOff process of each plane according to runway
	 */
	public static void takeOff(LinkedQueue runWay) {
		if(runWay == runway1) {
			System.out.println("Dequeueing from runway 1...");
			runway1.dequeue();
			runwayStatus();
		}
		else {
			System.out.println("Dequeueing from runway 2...");
			runway2.dequeue();
			runwayStatus();
		}
	}
	

	public static void runwayStatus() {
		System.out.println("\n\n------------------------------------------------");
		System.out.println("---- Current runway status ---------------------");
		System.out.println("Runway 1: " + runway1);
		System.out.println("Runway 2: " + runway2);
		System.out.println("------------------------------------------------");
	}
	
	public static void test() {
	   	ArrayList<Airplane> planes = new ArrayList<>();
	   		Collections.addAll(planes, plane1, plane2, plane3, plane4, plane5, plane6);
	   		Collections.shuffle(planes);
	   		for(int i = 0; i < 6; i++) {
	   			int rand = (int) (100 * Math.random()) + 2;
	   			if(rand % 2 == 0) {
	   		        runway1.enqueue(planes.get(i));
	   			}
	   			else if (rand % 2 == 1){
	   				runway2.enqueue(planes.get(i));
	   			}
	   		}
	}
	
	public static void testCase1 () {
		runway1.enqueue(plane1);
		runway1.enqueue(plane2);
		runway1.enqueue(plane3);
		runway1.enqueue(plane4);
		runway1.enqueue(plane5);
		runway1.enqueue(plane6);
	}
	public static void testCase2 () {
		runway2.enqueue(plane1);
		runway2.enqueue(plane2);
		runway2.enqueue(plane3);
		runway2.enqueue(plane4);
		runway2.enqueue(plane5);
		runway2.enqueue(plane6);
	}
	public static void testCase3 () {
		runway1.enqueue(plane1);
		runway1.enqueue(plane2);
		runway1.enqueue(plane3);
		runway2.enqueue(plane4);
		runway2.enqueue(plane5);
		runway2.enqueue(plane6);
	}
	
	public static void testCase4 () {
		runway1.enqueue(plane1);
		runway1.enqueue(plane2);
		runway1.enqueue(plane3);
		runway1.enqueue(plane4);
		runway1.enqueue(plane5);
		runway2.enqueue(plane6);
	}
	
	public static void testCase5 () {
		runway1.enqueue(plane1);
		runway1.enqueue(plane2);
		runway1.enqueue(plane3);
		runway2.enqueue(plane4);
		runway1.enqueue(plane5);
		runway2.enqueue(plane6);
	}
}
