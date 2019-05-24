/*
* @author David W. Clendenning Jr.
*/
package week9;

import java.util.ArrayList;
import java.util.Arrays;

public class PokemonSortAlgorithms {
	
	// Quicksort
	// https://www.programcreek.com/2012/11/quicksort-array-in-java/
	// TODO: quickSort method needs to be changed to sort Pokemon by speed instead
	public static void quickSort(Pokemon[] arr, int start, int end){

		int partition = partition(arr, start, end);

		if(partition-1>start) {
			quickSort(arr, start, partition - 1);
		}
		if(partition+1<end) {
			quickSort(arr, partition + 1, end);
		}
	}

	// helper method for quicksort
	// https://www.programcreek.com/2012/11/quicksort-array-in-java/
	// TODO: partition (which is used by the quickSort algorithm above)
	// method needs to be changed to sort Pokemon by speed instead
	public static int partition(Pokemon[] arr, int start, int end){
		Pokemon pivot = arr[end];

		for(int i=start; i<end; i++){
			if(arr[i].compareTo(pivot) < 0){
				Pokemon temp= arr[start];
				arr[start]=arr[i];
				arr[i]=temp;
				start++;
			}
		}

		Pokemon temp = arr[start];
		arr[start] = pivot;
		arr[end] = temp;

		return start;
	}


	// Shell sort
	// https://www.geeksforgeeks.org/shellsort/
	//OLD CODE: public static void shellSort(int arr[]) 
	public static void shellSort(Pokemon arr[]) 
	{ 
		int n = arr.length; 

		// Start with a big gap, then reduce the gap 
		for (int gap = n/2; gap > 0; gap /= 2) 
		{ 
			// Do a gapped insertion sort for this gap size. 
			// The first gap elements a[0..gap-1] are already 
			// in gapped order keep adding one more element 
			// until the entire array is gap sorted 
			for (int i = gap; i < n; i += 1) 
			{ 
				// add a[i] to the elements that have been gap 
				// sorted save a[i] in temp and make a hole at 
				// position i 
				// OLD CODE: int temp = arr[i];
				// Changed to use store a temporary pokemon object instead of int
				Pokemon temp = arr[i];

				// shift earlier gap-sorted elements up until 
				// the correct location for a[i] is found 
				int j;
				
				//OLD CODE: for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
				for (j = i; j >= gap && (arr[j - gap]).compareTo(temp) > 0; j -= gap) 
					arr[j] = arr[j - gap]; 

				// put temp (the original a[i]) in its correct 
				// location 
				arr[j] = temp; 
			} 
		} 
	}
	
	public static void radixSort(Pokemon arr[]) {
		final int RADIX = 10;
		
		// LET's come back to this maybe...
		ArrayList<Pokemon> bucketsArray[] = new ArrayList[RADIX];
		for(int i = 0; i < bucketsArray.length; i++) {
			bucketsArray[i] = new ArrayList<>();
		}
		
		boolean maxDigitsLengthReached = false;
		int temp = -1, placeValue = 1;
		while(!maxDigitsLengthReached) {
			maxDigitsLengthReached = true;
			for(Pokemon element : arr) {
				temp = element.getSpeed() / placeValue;
				bucketsArray[temp%RADIX].add(element);
				if(maxDigitsLengthReached && temp > 0) {
					maxDigitsLengthReached = false;
				}
			}
			int a = 0;
			for(int b = 0; b < RADIX; b++) {
				for(Pokemon i: bucketsArray[b]) {
					arr[a++] = i;
				}
				bucketsArray[b].clear();
			}
			placeValue = placeValue * RADIX;
		}
	}
		
}


