//David W. Clendenning Jr. - Week 7
package week7;

public class QueueTestDriver {
public static void main(String[] args) {
		
		// Test with some integers
		testIntegers();
		
		
		// Test with some strings
		testStrings();
		
		
		// Test with some airplanes
		testAirplanes();
		
	}

	
	
	public static void testIntegers() {
		System.out.println("\n\nTesting with some integers");

		LinkedQueue<Integer> myIntegerQueue = new LinkedQueue<>();
		
		int testSet[] = {1,2,3,4,5};
		
		for (int i = 0; i < testSet.length; i++) {
			myIntegerQueue.enqueue(testSet[i]);
		}
		System.out.println(myIntegerQueue);
		
		for (int i = 0; i < testSet.length; i++) {
			System.out.println("Dequeue " + myIntegerQueue.getFront());
			myIntegerQueue.dequeue();
			System.out.println(myIntegerQueue);
		}
		
		//What happens if we try to dequeue from an empty queue?
		System.out.println("Dequeue " + myIntegerQueue.getFront());
		myIntegerQueue.dequeue();
		System.out.println(myIntegerQueue);
	}

	public static void testStrings() {
		System.out.println("\n\nTesting with some strings");
		
		LinkedQueue<String> myStringQueue = new LinkedQueue<>();
		
		String testSet[] = {"Hello", "World", "How", "You", "Doing", "Today?"};
		
		for (int i = 0; i < testSet.length; i++) {
			myStringQueue.enqueue(testSet[i]);
		}
		System.out.println(myStringQueue);
		
		for (int i = 0; i < testSet.length; i++) {
			System.out.println("Dequeue " + myStringQueue.getFront());
			myStringQueue.dequeue();
			System.out.println(myStringQueue);
		}
		
		//What happens if we try to dequeue from an empty queue?
		System.out.println("Dequeue " + myStringQueue.getFront());
		myStringQueue.dequeue();
		System.out.println(myStringQueue);
	}
	
	public static void testAirplanes() {
		
		System.out.println("\n\nTesting with some Airplane objects");
		
		LinkedQueue<Airplane> myStringQueue = new LinkedQueue<>();
		
		Airplane plane1 = new Airplane("AA", 4992);
		Airplane plane2 = new Airplane("DL", 1345);
		Airplane plane3 = new Airplane("AA", 4531);
		Airplane plane4 = new Airplane("DL", 9873);
		
		Airplane testSet[] = {plane1, plane2, plane3, plane4};
		
		for (int i = 0; i < testSet.length; i++) {
			myStringQueue.enqueue(testSet[i]);
		}
		System.out.println(myStringQueue);
		
		for (int i = 0; i < testSet.length; i++) {
			System.out.println("Dequeue " + myStringQueue.getFront());
			myStringQueue.dequeue();
			System.out.println(myStringQueue);
		}
		
		//What happens if we try to dequeue from an empty queue?
		System.out.println("Dequeue " + myStringQueue.getFront());
		myStringQueue.dequeue();
		System.out.println(myStringQueue);
		
	}
}
