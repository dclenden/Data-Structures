/*
* @author David W. Clendenning Jr.
*/
package exam3;

import java.util.Arrays;

public class MergeSortTester {
	public static void main(String args[]) 
	{ 
		int arr[] = {12, 11, 13, 5, 6, 7}; 

		System.out.println("Given Array"); 
		System.out.println(Arrays.toString(arr)); 

		MergeSort.sort(arr, 0, arr.length-1); 

		System.out.println("\nSorted array"); 
		System.out.println(Arrays.toString(arr)); 
	}
}