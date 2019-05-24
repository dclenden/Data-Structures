//David W. Clendenning Jr. - CIS211 - Exam 1
package exam1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
/* Abstraction is a way to make your data private and hide the implementation details from the user */
public class PokedexDriverCSV {
	public static void main(String[] args) {
		Pokedex pokedex = new Pokedex();
		Pokedex highAttackPokemon = new Pokedex();
		Pokedex highDefensePokemon = new Pokedex();
		Pokedex lowStatPokemon = new Pokedex();

        // automatically closes buffered reader instead of using a finally block
		try(BufferedReader br = new BufferedReader(new FileReader("pokemon.csv"))) {
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter a type of pokemon to view (ex: Grass, Flying, Fire... etc.)");
			String inputType = input.nextLine();
			/* formatting the typeChosen for user input, allowing for any capitals / lower case inputs */
			String typeChosen = inputType.substring(0, 1).toUpperCase() + inputType.substring(1).toLowerCase();
			
			
			String line = "";
			//Read to skip the header
			br.readLine();
			//Reading from the second line
			while ((line = br.readLine()) != null) 
			{
				String[] pokemonDetails = line.split(",");

				if(pokemonDetails.length > 0 )
				{
					//Create a temporary pokemon
					String name = pokemonDetails[1];
					String type = pokemonDetails[2];
					int hp = Integer.parseInt(pokemonDetails[5]);
					int atk = Integer.parseInt(pokemonDetails[6]);
					int def = Integer.parseInt(pokemonDetails[7]);
					/* constructs pokemon for each iteration of loop with easy to read code */
					Pokemon pokemon = new Pokemon(name, type, hp, atk, def);
					/* by defaults adds all pokemon to the pokedex (the base one) */
					pokedex.addPokemon(pokemon);
					/* logic that decides which pokedex will hold a pokemon, if the pokemon has both high
					 * attack and defense it is held in both pokedex's, if the attack is greater that the defense
					 * it is held in the highAttackPokemon pokedex, as well as the opposite holds true for the
					 * highDefensePokemon pokedex. To top it all off I added a lowStatPokemon that will hold the rest,
					 * of the pokemon that are under 100 in both attack and defense.
					 */
					if(pokemon.getAttack() > 100 && pokemon.getDefense() > 100 
							&& pokemon.getType1().equals(typeChosen)) {
						highAttackPokemon.addPokemon(pokemon);
						highDefensePokemon.addPokemon(pokemon);
					}
					else if(pokemon.getAttack() > 100 && pokemon.getType1().equals(typeChosen) ) {
						highAttackPokemon.addPokemon(pokemon);
					}
					else if(pokemon.getDefense() > 100 && pokemon.getType1().equals(typeChosen)) {
						highDefensePokemon.addPokemon(pokemon);
					}
					else if(pokemon.getDefense() < 100 && pokemon.getAttack() < 100 
							&& pokemon.getType1().equals(typeChosen)) {
						lowStatPokemon.addPokemon(pokemon);
					}
				}
			}
			/* System.out.println("############ POKEDEX CONTENTS ############");
			 * System.out.println(pokedex);
			 * Print this if you want to see the other ~800 pokemon
			 */
			System.out.println("############ CHOSEN TYPE ############");
			System.out.println(typeChosen);
			System.out.println("\n");
			System.out.println("############ HIGH ATTACK POKEDEX CONTENTS ############");
			System.out.println(highAttackPokemon);
			System.out.println("\n\n");
			System.out.println("############ HIGH DEFENSE POKEDEX CONTENTS ############");
			System.out.println(highDefensePokemon);
			/* print this if you would like to see the weak pokemon that are below 100 in both attack and defense
			System.out.println("############ HIGH DEFENSE POKEDEX CONTENTS ############");
			System.out.println(lowStatPokemon);
			*/
		}
		/* catches error if the file is not found on your computer */
        catch(FileNotFoundException e) {
    		System.out.println("File not found, please check your file system");
    	}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
}

