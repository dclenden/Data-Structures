/*
* @author David W. Clendenning Jr.
*/
package week9;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Part2HashMap {
	static Pokemon pokemon[] = new Pokemon[800];
	/* stores a Pokemon object by name */
	static HashMap<String, Pokemon> pokemonHashMap = new HashMap<>();
	
	public static void main(String[] args) {
		readPokemonCSV();
		try {
			getPokeData("Pikachu");
			getPokeData("Charmander");
			getPokeData("Squirtle");
			getPokeData("Bulbasaur");
			getPokeData("Charizard");
			/* or */
			System.out.println(pokemonHashMap.get("Pikachu"));
			getPokeData("asdfdsaf");
		
		}
		catch(NullPointerException ee) {
			System.out.println("You must have mispelled your pokemon's name:"
					+ " please try again (make sure the first letter is capital)");
		}
		//System.out.println(pokemonHashMap);
		// TODO: Write test code to retrieve a few pokemon by name
	}
	/* a method to pull the PokemonData from the HashMap by Key (like a get method but i wanted to change the format without
	changing the toString() */
	public static void getPokeData(String keyName) {
		System.out.println("Pokemon Name: " + pokemonHashMap.get(keyName).getName()/* just to confirm correct pokemon */
				+ "\nPokemon Speed: " + pokemonHashMap.get(keyName).getSpeed() + "\nTotal: " 
				+ pokemonHashMap.get(keyName).getTotal() + "\n");
	}
	
	static void readPokemonCSV() {
		// The following is adapted from Example 1. Using Buffered Reader and String.split() from https://www.javainterviewpoint.com/how-to-read-and-parse-csv-file-in-java/
		BufferedReader br = null;
		int pokemonCount = 0;
		try
		{
			//Reading the csv file
			br = new BufferedReader(new FileReader("pokemon.csv"));

			//Create List for holding Pokemon objects
			//List<Pokemon> pokemonList = new ArrayList<Pokemon>();

			String line = "";
			//Read to skip the header
			br.readLine();
			//Reading from the second line
			while ((line = br.readLine()) != null) 
			{
				String[] pokemonDetails = line.split(",");
				// When the string is split, it will result in an array with the following information in the corresponding index
				// 0 - #
				// 1 - Name
				// 2 - Type1
				// 3 - Type2
				// 4 - Total
				// 5 - HP
				// 6 - Attack
				// 7 - Defense
				// 8 - Sp. Atk
				// 9 - Sp. Def
				// 10 - Speed
				// 11 - Generation
				// 12 - Legendary
				// *Note that pokemonDetails is an array of strings, so it must be cast to the appropriate data type when used in your program

				if(pokemonDetails.length > 0 )
				{
					//Create a temporary pokemon
					Pokemon tempPokemon = new Pokemon();
					
					tempPokemon.setName(pokemonDetails[1]);
					tempPokemon.setSpeed(Integer.valueOf(pokemonDetails[10]));
					tempPokemon.setTotal(Integer.valueOf(pokemonDetails[4]));

					pokemon[pokemonCount++] = tempPokemon;
					// TODO: instead of saving pokemon objects into an array
					// save them into a HashMap
					pokemonHashMap.put(pokemonDetails[1], tempPokemon);
				}
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
			}
			catch(IOException ie)
			{
				System.out.println("Error occured while closing the BufferedReader");
				ie.printStackTrace();
			}
		}
		// End of code adapted from Example 1. Using Buffered Reader and String.split() from https://www.javainterviewpoint.com/how-to-read-and-parse-csv-file-in-java/

	}
}
