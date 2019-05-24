//David W. Clendenning Jr. - CIS211 - week 4-5
package week4;

public class StackTestDriver {
	public static void main(String[] args) {
		LinkedStack<Integer> numberContainer = new LinkedStack<>();
		LinkedStack<String> wordContainer = new LinkedStack<>();
		LinkedStack<Pokemon> pokedex = new LinkedStack<>();
		
		// Fill the numberContainer object with numbers from 0 to 23
		for (int i = 0; i < 24; i++) {
			numberContainer.push(i);
		}
		System.out.println(numberContainer); // This line won't work until the toString method is overriden properly
		numberContainer.printList();
		
		wordContainer.push("Hello");
		wordContainer.push("World");
		wordContainer.push("This");
		wordContainer.push("Is");
		wordContainer.push("A");
		wordContainer.push("Container");
		System.out.println(wordContainer); // This line won't work until the toString method is overriden properly
		wordContainer.printList();

		pokedex.push(new Pokemon("Bulbasaur", "Grass", 45));
		pokedex.push(new Pokemon("Ivysaur", "Grass", 60));
		pokedex.push(new Pokemon("Venusaur", "Grass", 80));
		pokedex.push(new Pokemon("VenusaurMega Venusaur", "Grass", 80));
		System.out.println(pokedex);
		System.out.println("before pop: " + pokedex.peek());
		pokedex.pop();
		System.out.println("after pop: " + pokedex.peek());
		System.out.println(pokedex); // This line won't work until the toString method is overriden properly
		pokedex.printList();

	}
}
