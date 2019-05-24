//David W. Clendenning Jr. - CIS211 - Week 3
package week3;

public class ArrayContainerDriver {
	public static void main(String[] args) {

		ArrayContainer<Integer> numberContainer = new ArrayContainer<>();
		ArrayContainer<String> wordContainer = new ArrayContainer<>();
		ArrayContainer<Pokemon> pokedex = new ArrayContainer<>();
		
		// Fill the numberContainer object with numbers from 0 to 23
		for (int i = 0; i < 24; i++) {
			numberContainer.add(i);
		}
		
		System.out.println(numberContainer);

		// Check if it's full
		if (numberContainer.isFull()) {
			System.out.println("The number container object is full!\n\n");
		} else {
			System.out.println("The number container object is NOT full!\n\n");
		}

		// Try to add another item - this should work, since there are 24 items in this container
		numberContainer.add(99);
		System.out.println(numberContainer);

		// Check if it's full
		if (numberContainer.isFull()) {
			System.out.println("The number container object is full!\n\n");
		} else {
			System.out.println("The number container object is NOT full!\n\n");
		}

		// Try to add another item - this should not work, since there are already 25 items in this container
		numberContainer.add(100);
		System.out.println(numberContainer);
		

		
		wordContainer.add("Hello");
		wordContainer.add("World");
		wordContainer.add("This");
		wordContainer.add("Is");
		wordContainer.add("A");
		wordContainer.add("Container");
		System.out.println(wordContainer);

		pokedex.add(new Pokemon("Bulbasaur", "Grass", 45));
		pokedex.add(new Pokemon("Ivysaur", "Grass", 60));
		pokedex.add(new Pokemon("Venusaur", "Grass", 80));
		pokedex.add(new Pokemon("VenusaurMega Venusaur", "Grass", 80));
		System.out.println(pokedex);

	}
}
