/*
* @author David W. Clendenning Jr.
*/
package week10;

import java.util.Arrays;
import java.util.Scanner;

public class useSortInt {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Please specify the size of the sample data. (100, 1000, 10000, 100000)");
    	int size = input.nextInt();
    	
    	if(size <= 0) {
    		System.out.println("The size cannot be zero or a negative number, please restart the program");
    		System.exit(0);
    	}
        //java.io.PrintStream out = System.out;
    	long[] quickSortRunTimes = new long[50]; /*stores each simulation of the specified sorting algorithm*/
    	long[] shellSortRunTimes = new long[50];
    	long[] insertionSortRunTimes = new long[50];
    	long[] selectionSortRunTimes = new long[50];
    	
    	for(int i = 0; i < 50; i++) {
    		int[] ar = SortInt.generateRandomArray(size); /* creates 4 arrays with the same exact elements for each simulation*/
        	int[] ar1 = Arrays.copyOf(ar, ar.length);
        	int[] ar2 = Arrays.copyOf(ar, ar.length);
        	int[] ar3 = Arrays.copyOf(ar, ar.length);
        	/*System.out.println(Arrays.toString(ar));
        	System.out.println(Arrays.toString(ar1));
        	System.out.println(Arrays.toString(ar2));
        	System.out.println(Arrays.toString(ar3));*/
    		quickSortRunTimes[i] = SortInt.quickSortRuntimes(ar); /*stores each runtime into its respective index*/
    		shellSortRunTimes[i] = SortInt.shellSortRuntimes(ar1);
    		insertionSortRunTimes[i] = SortInt.insertionSortRuntimes(ar2);
    		selectionSortRunTimes[i] = SortInt.selectionSortRuntimes(ar3);
    		/*System.out.println(Arrays.toString(ar));
    		System.out.println(Arrays.toString(ar1));
    		System.out.println(Arrays.toString(ar2));
    		System.out.println(Arrays.toString(ar3));*/
    	}
    	
    	/*calculates the SD and the MT for each sort*/
    	System.out.println("QuickSort: " + "\nMT: " + SortInt.calculateMT(quickSortRunTimes) + " nanoseconds"
    	        + "\nSD: " + SortInt.calculateSD(quickSortRunTimes) + " nanoseconds\n\n");
    	System.out.println("ShellSort: " + "\nMT: " + SortInt.calculateMT(shellSortRunTimes) + " nanoseconds"
    	        + "\nSD: " + SortInt.calculateSD(shellSortRunTimes) + " nanoseconds\n\n");
    	System.out.println("InsertionSortRunTimes: " + "\nMT: " + SortInt.calculateMT(insertionSortRunTimes) + " nanoseconds"
    	        + "\nSD: " + SortInt.calculateSD(insertionSortRunTimes) + " nanoseconds\n\n");
    	System.out.println("SelectionSortRunTimes: " + "\nMT: " + SortInt.calculateMT(selectionSortRunTimes) + " nanoseconds"
    	        + "\nSD: " + SortInt.calculateSD(selectionSortRunTimes) + " nanoseconds\n\n");
    }
}
