/*
* @author David W. Clendenning Jr.
*/
package week10;

import java.util.Arrays;
import java.util.Scanner;

public class SortInt {
	static Scanner input = new Scanner(System.in);
	static {
		//System.out.print("MAXINT = ");             /* if you want to choose your max int you can with the comment code*/
	}
	static final int MAXINT = 1000; //input.nextInt();
    static long quickSortRuntimes(int quickSortArray[]) {
		//System.out.println("Quick sort demo using ints");
		//System.out.println(Arrays.toString(quickSortArray));
		final long quickSortStart = System.nanoTime();
		
		IntSortAlgorithms.quickSort(quickSortArray, 0, quickSortArray.length-1);
		
		final long quickSortDuration = System.nanoTime() - quickSortStart;
		return quickSortDuration;
		//System.out.println("\nThe quick sort took " + quickSortDuration + " nanoseconds or " + quickSortDuration/1e9 + " seconds." );		
		//System.out.println(Arrays.toString(quickSortArray));
	}
	
	static long shellSortRuntimes(int shellSortArray[]) {
		//System.out.println("\nShell sort demo using ints");
		//System.out.println(Arrays.toString(shellSortArray));
		
		final long shellSortStart = System.nanoTime();
		
		IntSortAlgorithms.shellSort(shellSortArray);
		
		final long shellSortDuration = System.nanoTime() - shellSortStart;
		return shellSortDuration;
		//System.out.println("The Shell sort took " + shellSortDuration + " nanoseconds or " + shellSortDuration/1e9 + " seconds." );
		//System.out.println(Arrays.toString(shellSortArray));
	}
	
	static long insertionSortRuntimes(int insertionSortArray[]) {
		final long insertionSortStart = System.nanoTime();
		
		IntSortAlgorithms.insertionSort(insertionSortArray);
		
		final long insertionSortDuration = System.nanoTime() - insertionSortStart;
		return insertionSortDuration;
	}
	//https://www.geeksforgeeks.org/selection-sort/
	static long selectionSortRuntimes(int selectionSortArray[]) {
		final long selectionSortStart = System.nanoTime();
		
		IntSortAlgorithms.selectionSort(selectionSortArray);
		
		final long selectionSortDuration = System.nanoTime() - selectionSortStart;
		return selectionSortDuration;
	}
	//https://www.geeksforgeeks.org/insertion-sort/
	static int[] generateRandomArray(int arraySize) {
		int randomArray[] = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			randomArray[i] = (int)(Math.random()*(MAXINT + 1)); // min + (int)(Math.random() * (max - min))
		}
		return randomArray;
	}
	/* taken from source provided by instructor */
	public static double calculateSD(long numArray[]) {
        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.length;

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }
	
	public static double calculateMT(long numArray[]) {
		double sum = 0.0, total = 0.0;
		for(double i: numArray) {
			sum += i;
		}
		total = sum/numArray.length;
		return total;
	}
	

}
