/*
* @author David W. Clendenning Jr.
*/
package exam2;
import java.util.*;


public class AirControlB {
	static Deque<Airplane> runway1 = new ArrayDeque<>();
	static Deque<Airplane> runway2 = new ArrayDeque<>();
	static Deque<Airplane> maintenance1 = new ArrayDeque<>();
	static Deque<Airplane> maintenance2 = new ArrayDeque<>();

	static Airplane plane1 = new Airplane("AA", 4992);
	static Airplane plane2 = new Airplane("DL", 1345);
	static Airplane plane3 = new Airplane("AA", 4531);
	static Airplane plane4 = new Airplane("DL", 9873);
	static Airplane plane5 = new Airplane("AA", 3414);
	static Airplane plane6 = new Airplane("DL", 2366);
	
	public static void main(String[] args) {
		//test(); //<- if you want to play with random test cases
		testCase4(); //<- the test case I used to match your output
        simulate();
        
	} 
	
	
	public static void simulate() {
		Scanner input = new Scanner(System.in);
        boolean flag = false;
		while (!runway1.isEmpty() || !runway2.isEmpty()) {
			printRunway();
			airControlmenu();
			int choice = input.nextInt();
			if(choice == 1) {
				if(flag == false) {
				    try {
				    	if(!runway1.isEmpty()) {
						    System.out.println("Taking off from runway 1");
					        System.out.println("Fly safe, plane: " + runway1.removeFirst());
						}
						else {
							System.out.println("runway1 is empty: we shall now send off runway2 instead");
							System.out.println("Fly safe, plane: " + runway2.removeFirst());
						}
					}
					catch(NoSuchElementException e) {
						System.out.println("There seems to be an error, there is a " + e);
					}
				    flag = true;
				}
				else {
					try {
						if(!runway2.isEmpty()) {
							System.out.println("Taking off from runway 2");
							System.out.println("Fly safe, plane: " + runway2.removeFirst());
						}
						else {
							System.out.println("runway2 is empty: we shall now send off runway1 instead");
							System.out.println("Fly safe, plane: " + runway1.removeFirst());
						}
					}
					catch(NoSuchElementException e) {
						System.out.println("There seems to be an error, there is" + e);
					}
					flag = false;
				}
			}
			else if(choice == 2) {
				try {
					maintenance1.add(runway1.removeLast());
					System.out.println("We are now taking the last plane on runway1 to the terminal for maintenance");
					}
					catch(NoSuchElementException e) {
						System.out.println("There seems to be no planes, there is a " + e + " we can't maintain nothing!");
					}
			}
			else if(choice == 3) {
				try {
					maintenance2.add(runway2.removeLast());
					System.out.println("We are now taking the last plane on runway2 to the terminal for maintenance");
					}
					catch(NoSuchElementException e) {
						System.out.println("There seems to be no planes, there is a " + e + " we can't maintain nothing!");
					}
			}
			else {
				System.out.println("Invalid input:: Please enter a number 1 - 3 based on the options given");
			}
		}
		
		System.out.println("\n\nThere are no more planes on runways 1 and 2.");
		input.close();
	}
	
    	
    
	public static void airControlmenu() {
		System.out.println("\n1: Next plane is cleared for takeoff");
		System.out.println("2: Last plane on runway 1 must return to terminal.");
		System.out.println("3: Last plane on runway 2 must return to terminal.");
	}

	public static void printRunway() {
		System.out.println("\n\n##### AIR TRAFFIC CONTROL MENU #####");
		System.out.println("Runway1: " + runway1);
		System.out.println("Runway2: " + runway2);
		System.out.println("Maintenance 1: " + maintenance1);
		System.out.println("Maintenance 2: " + maintenance2);
	}
    public static void test() {
    	ArrayList<Airplane> planes = new ArrayList<>();
   		Collections.addAll(planes, plane1, plane2, plane3, plane4, plane5, plane6);
   		Collections.shuffle(planes);
   		for(int i = 0; i < 6; i++) {
   			int rand = (int) (100 * Math.random()) + 2;
   			if(rand % 2 == 0) {
   		        runway1.add(planes.get(i));
   			}
   			else if (rand % 2 == 1){
   				runway2.add(planes.get(i));
   			}
   		}
    }
	public static void testCase1 () {
		runway1.add(plane1);
		runway1.add(plane2);
		runway1.add(plane3);
		runway1.add(plane4);
		runway1.add(plane5);
		runway1.add(plane6);
	}
	public static void testCase2 () {
		runway2.add(plane1);
		runway2.add(plane2);
		runway2.add(plane3);
		runway2.add(plane4);
		runway2.add(plane5);
		runway2.add(plane6);
	}
	public static void testCase3 () {
		runway1.add(plane1);
		runway1.add(plane2);
		runway1.add(plane3);
		runway2.add(plane4);
		runway2.add(plane5);
		runway2.add(plane6);
	}

	public static void testCase4 () {
		runway1.add(plane1);
		runway1.add(plane2);
		runway1.add(plane3);
		runway1.add(plane4);
		runway1.add(plane5);
		runway2.add(plane6);
	}
}