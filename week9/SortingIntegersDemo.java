/*
* @author David W. Clendenning Jr.
*/
package week9;

public class SortingIntegersDemo {

	static final int ARRAY_SIZE = 500000;
	public static void main(String[] args) {
		
		quickSortDemo();
		shellSortDemo();

	}

	static void quickSortDemo() {
		System.out.println("Quick sort demo using ints");
		int quickSortArray[] = generateRandomArray(ARRAY_SIZE);
		//System.out.println(Arrays.toString(quickSortArray));
		final long quickSortStart = System.nanoTime();
		
		IntSortAlgorithms.quickSort(quickSortArray, 0, ARRAY_SIZE-1);
		
		final long quickSortDuration = System.nanoTime() - quickSortStart;
		System.out.println("\nThe quick sort took " + quickSortDuration + " nanoseconds or " + quickSortDuration/1e9 + " seconds." );		
		//System.out.println(Arrays.toString(quickSortArray));
	}
	
	static void shellSortDemo() {
		System.out.println("\nShell sort demo using ints");
		int shellSortArray[] = generateRandomArray(ARRAY_SIZE);
		//System.out.println(Arrays.toString(shellSortArray));
		
		final long shellSortStart = System.nanoTime();
		
		IntSortAlgorithms.shellSort(shellSortArray);
		
		final long shellSortDuration = System.nanoTime() - shellSortStart;
		
		System.out.println("The Shell sort took " + shellSortDuration + " nanoseconds or " + shellSortDuration/1e9 + " seconds." );
		//System.out.println(Arrays.toString(shellSortArray));
	}
	
	static int[] generateRandomArray(int arraySize) {
		int randomArray[] = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			randomArray[i] = (int)(Math.random()*1000);
		}
		return randomArray;
	}


}
