//David W. Clendenning Jr. - CIS211 - Week 2
package week2;
public class Pokedex implements PokedexInterface{
	private Pokemon[] pokedex = new Pokemon[1000];
	private int numPokemon = 0;
	@Override
	public String toString() {
		/*for(Pokemon pokemon: pokedex) {
			if(pokemon != null) {
			    System.out.println(pokemon);
			}
			else {
				break;
			}
		}
		return "";*/
		// decided to implement a StringBuilder in order to return a single string
		StringBuilder result = new StringBuilder();
		for(Pokemon p: pokedex) {
			if(p != null) {
			    result.append(p);
			    result.append("\n");
			}
			else {
				
			}
		}
		return result.toString();
	}
// increments the counter for the add function
	public void addPokemon(Pokemon pokemon) {
			pokedex[numPokemon] = pokemon;
			numPokemon++;
	}
}
