//David W. Clendenning Jr. - CIS211 - Week 2
package week2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokedexDriverCSV {
	public static void main(String[] args) {
		Pokedex pokedex = new Pokedex();

		// The following is adapted from Example 1. Using Buffered Reader and String.split() from https://www.javainterviewpoint.com/how-to-read-and-parse-csv-file-in-java/
        // automatically closes buffered reader instead of using a finally block
		try(BufferedReader br = new BufferedReader(new FileReader("pokemon.csv"))) {
			
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
					Pokemon pokemon = new Pokemon();

					//Save the Pokemon details in Pokemon object
					pokemon.setHP(Integer.parseInt(pokemonDetails[5]));
					pokemon.setName(pokemonDetails[1]);
					pokemon.setType1(pokemonDetails[2]);
					pokedex.addPokemon(pokemon);
				}
			}

			System.out.println("############ POKEDEX CONTENTS ############");
			System.out.println(pokedex);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
}

