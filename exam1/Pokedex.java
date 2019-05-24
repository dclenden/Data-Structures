//David W. Clendenning Jr. - CIS211 - Exam 1
package exam1;
public class Pokedex implements PokedexInterface{
	private Pokemon[] pokedex = new Pokemon[1000];
	private int numPokemon = 0;
	@Override
	public String toString() {

		// uses StringBuilder in order to return a single string
		StringBuilder result = new StringBuilder();
		for(Pokemon p: pokedex) {
			if(p != null) {
			    result.append(p);
			    result.append("\n");
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
