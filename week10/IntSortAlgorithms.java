/*
* @author David W. Clendenning Jr.
*/
package week10;

public class IntSortAlgorithms {
	// Quicksort
		// https://www.programcreek.com/2012/11/quicksort-array-in-java/
		public static void quickSort(int[] arr, int start, int end){

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
		public static int partition(int[] arr, int start, int end){
			int pivot = arr[end];

			for(int i=start; i<end; i++){
				if(arr[i]<pivot){
					int temp= arr[start];
					arr[start]=arr[i];
					arr[i]=temp;
					start++;
				}
			}

			int temp = arr[start];
			arr[start] = pivot;
			arr[end] = temp;

			return start;
		}


		// Shell sort
		// https://www.geeksforgeeks.org/shellsort/
		public static void shellSort(int arr[]) 
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
					int temp = arr[i]; 

					// shift earlier gap-sorted elements up until 
					// the correct location for a[i] is found 
					int j; 
					for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
						arr[j] = arr[j - gap]; 

					// put temp (the original a[i]) in its correct 
					// location 
					arr[j] = temp; 
				} 
			} 
		} 
		
		public static void insertionSort(int arr[]) {
			 int n = arr.length; 
		        for (int i = 1; i < n; ++i) { 
		            int key = arr[i]; 
		            int j = i - 1; 
		  
		            /* Move elements of arr[0..i-1], that are 
		               greater than key, to one position ahead 
		               of their current position */
		            while (j >= 0 && arr[j] > key) { 
		                arr[j + 1] = arr[j]; 
		                j = j - 1; 
		            } 
		            arr[j + 1] = key; 
		        } 
		}
		
		public static void selectionSort(int arr[]) {
			int n = arr.length; 
			  
	        // One by one move boundary of unsorted subarray 
	        for (int i = 0; i < n-1; i++) 
	        { 
	            // Find the minimum element in unsorted array 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++) 
	                if (arr[j] < arr[min_idx]) 
	                    min_idx = j; 
	  
	            // Swap the found minimum element with the first 
	            // element 
	            int temp = arr[min_idx]; 
	            arr[min_idx] = arr[i]; 
	            arr[i] = temp; 
	        } 
		}
}
