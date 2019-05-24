//David W. Clendenning Jr. - CIS211 - Week 2
package week2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PokedexDriver {
	public static void main(String[] args) {
		Pokemon poke1 = new Pokemon("Pikachu", "Electric", 100);
		Pokemon poke2 = new Pokemon("Charizard", "Fire", 150);
		Pokemon poke3 = new Pokemon("Bulbusaur", "Grass", 200);

		Pokedex pokedex = new Pokedex();
		pokedex.addPokemon(poke1);
		pokedex.addPokemon(poke2);
		pokedex.addPokemon(poke3);

		System.out.println(pokedex);
	}

}