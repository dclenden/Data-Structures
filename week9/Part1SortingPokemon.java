/*
* @author David W. Clendenning Jr.
*/
package week9;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Part1SortingPokemon {
	static int NUM_POKEMON = 800;
	static Pokemon pokemon[] = new Pokemon[NUM_POKEMON];
	
	public static void main(String[] args) {
		readPokemonCSV();
		
		testShellSort(); //TODO: TEST ONE AT A TIME (could not get a deep clone to work for the array of pokemon)
		//testQuickSort();
        //testRadixSort(); //this works for integers by taking modulus base and reiterating through each int from LSD to MSD
		
		
		//TODO: Add code for sorting the pokemon array using the quick sort algorithm
		//TODO: Add code for timing each algorithm
	}
	/* various methods to test different sorts that will also output their time by calling their respective demo methods */
	static void testRadixSort() {
    	System.out.println("Unsorted: ");
		System.out.println(Arrays.toString(pokemon));
		
		radixSortDemo();
		
		System.out.println("Sorted: ");
		System.out.println(Arrays.toString(pokemon));
	}
    static void testShellSort() {
    	System.out.println("Unsorted: ");
		System.out.println(Arrays.toString(pokemon));
		
		shellSortDemo();
		
		System.out.println("Sorted: ");
		System.out.println(Arrays.toString(pokemon));
    }
    static void testQuickSort() {
    	System.out.println("Unsorted: ");
		System.out.println(Arrays.toString(pokemon));
		
		quickSortDemo();
		
		System.out.println("Sorted: ");
		System.out.println(Arrays.toString(pokemon));
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
	static void quickSortDemo() {
		System.out.println("Quick sort demo using Pokemon\n");
		Pokemon quickSortArray[] = pokemon;
		//System.out.println(Arrays.toString(quickSortArray));
		final long quickSortStart = System.nanoTime();
		
		PokemonSortAlgorithms.quickSort(quickSortArray, 0, NUM_POKEMON-1);
		
		final long quickSortDuration = System.nanoTime() - quickSortStart;
		System.out.println("\nThe quick sort took " + quickSortDuration + " nanoseconds or " + quickSortDuration/1e9 + " seconds.\n" );		
		//System.out.println(Arrays.toString(quickSortArray));
	}
	
	static void shellSortDemo() {
		System.out.println("\nShell sort demo using Pokemon\n");
		Pokemon shellSortArray[] = pokemon;
		//System.out.println(Arrays.toString(shellSortArray));
		
		final long shellSortStart = System.nanoTime();
		
		PokemonSortAlgorithms.shellSort(shellSortArray);
		
		final long shellSortDuration = System.nanoTime() - shellSortStart;
		
		System.out.println("The Shell sort took " + shellSortDuration + " nanoseconds or " + shellSortDuration/1e9 + " seconds.\n" );
		//System.out.println(Arrays.toString(shellSortArray));
	}
	static void radixSortDemo() {
		System.out.println("\nRadix sort demo using Pokemon\n");
		Pokemon radixSortArray[] = pokemon;
		//System.out.println(Arrays.toString(shellSortArray));
		
		final long radixSortStart = System.nanoTime();
		
		PokemonSortAlgorithms.radixSort(radixSortArray);
		
		final long radixSortDuration = System.nanoTime() - radixSortStart;
		
		System.out.println("The Radix sort took " + radixSortDuration + " nanoseconds or " + radixSortDuration/1e9 + " seconds.\n" );
		//System.out.println(Arrays.toString(shellSortArray));
	}
}
