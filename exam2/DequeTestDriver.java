/*
* @author David W. Clendenning Jr.
*/
package exam2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class DequeTestDriver {

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

		Deque<Integer> myIntegerDeque = new ArrayDeque<>();

		int testSet[] = {1,2,3,4,5};

		for (int i = 0; i < testSet.length; i++) {
			myIntegerDeque.addLast(testSet[i]);
		}
		System.out.println(myIntegerDeque);

		for (int i = 0; i < testSet.length; i++) {
			System.out.println("Delete last " + myIntegerDeque.peekLast());
			myIntegerDeque.removeLast();
			System.out.println(myIntegerDeque);
		}

		//What happens if we try to dequeue from an empty queue?
		try {
			System.out.println("Delete last " + myIntegerDeque.peekLast());
			myIntegerDeque.removeLast();
		} catch(NoSuchElementException e) {
			System.out.println("Exception caught! " + e);
		}
		System.out.println(myIntegerDeque);
	}

	public static void testStrings() {
		System.out.println("\n\nTesting with some strings");

		Deque<String> myStringDeque = new ArrayDeque<>();

		String testSet[] = {"Hello", "World", "How", "You", "Doing", "Today?"};

		for (int i = 0; i < testSet.length; i++) {
			myStringDeque.addLast(testSet[i]);
		}
		System.out.println(myStringDeque);

		for (int i = 0; i < testSet.length; i++) {
			System.out.println("Delete last " + myStringDeque.peekLast());
			myStringDeque.removeLast();
			System.out.println(myStringDeque);
		}

		//What happens if we try to dequeue from an empty queue?
		try {
			System.out.println("Delete last " + myStringDeque.peekLast());
			myStringDeque.removeLast();
		} catch(NoSuchElementException e) {
			System.out.println("Exception caught! " + e);
		}
		System.out.println(myStringDeque);

	}

	public static void testAirplanes() {

		System.out.println("\n\nTesting with some Airplane objects");

		Deque<Airplane> myStringDeque = new ArrayDeque<>();

		Airplane plane1 = new Airplane("AA", 4992);
		Airplane plane2 = new Airplane("DL", 1345);
		Airplane plane3 = new Airplane("AA", 4531);
		Airplane plane4 = new Airplane("DL", 9873);

		Airplane testSet[] = {plane1, plane2, plane3, plane4};

		for (int i = 0; i < testSet.length; i++) {
			myStringDeque.addLast(testSet[i]);
		}
		System.out.println(myStringDeque);

		for (int i = 0; i < testSet.length; i++) {
			System.out.println("Delete last " + myStringDeque.peekLast());
			myStringDeque.removeLast();
			System.out.println(myStringDeque);
		}

		//What happens if we try to dequeue from an empty queue?
		try {
			System.out.println("Delete last " + myStringDeque.peekLast());
			myStringDeque.removeLast();
		} catch(NoSuchElementException e) {
			System.out.println("Exception caught! " + e);
		}
		System.out.println(myStringDeque);

	}
}