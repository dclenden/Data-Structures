//David W. Clendenning Jr. - CIS211 - Week 1
package week1;
import java.util.ArrayList;
import java.util.Collections;
public class PokemonDriver {
	public static void main(String[] args) {
		/* creating instances of Pokemon and having a reference of PokemonInterface */
		PokemonInterface pikachu = new Pokemon();
		ArrayList<PokemonInterface> pokemonList = new ArrayList<>();
		/* getters/setters */
		pikachu.setHP(100);
		pikachu.setName("Pikachu");
		pikachu.setType1("Electric");
		PokemonInterface charizard = new Pokemon("Charizard", "Fire", 150);
		PokemonInterface squirtle = new Pokemon("Squirtle", "Water", 130);
		
		Collections.addAll(pokemonList, pikachu, charizard, squirtle);
		
		/* calls toString on each item in ArrayList by default */
		for (PokemonInterface pokemon: pokemonList) {
			System.out.println(pokemon);
		}

	}

}
