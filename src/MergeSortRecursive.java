
//Source: https://www.sanfoundry.com/java-program-implement-merge-sort/
//Video Source: https://www.youtube.com/watch?v=iMT7gTPpaqw

import java.util.Scanner; //Import Scanner

public class MergeSortRecursive { // Declare class

	// The main method of this program does a number of tasks which prepare the
	// array for sorting
	// Specifically, it takes user input to determine the length of the array to
	// be sorted, creates
	// an array of said length, and allows user input to populate the array
	// before finally calling
	// the mergeSort function
	public static void main(String[] args) { // Declare main function
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); // Create new Scanner object
		int length, i;

		// Get user input for the length of the array
		System.out.println("How long would you like the array to be?");
		System.out.println("");
		length = scanner.nextInt(); // Store user input as integer variable "length"

		// Create an array of the user-specified length
		int array[] = new int[length];

		// Get user input to populate the array
		System.out.println("Please enter " + length + " numbers to be sorted");
		// Use a for-loop to add each user-inputted integer to the array
		for (i = 0; i < length; i++)
			array[i] = scanner.nextInt();
		// Call the mergeSort function, passing the array, integer 0, and the length of
		// the array as an argument
		mergeSort(array, 0, length);

		// Output the sorted array to the user
		System.out.println("The sorted array");
		for (i = 0; i < length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	public static void mergeSort(int[] a, int low, int high) { // Declare the mergeSort function, receiving the 0 and
																// length arguments as low and high
		int N = high - low; // Create and assign a new integer "N" as the length of the array
		if (N <= 1) // If the low index is equal to the high index, the length of the array is one,
					// so return. (I.e. the base case for this recursive method)
			return;
		int mid = low + N / 2; // Calculate the midpoint in the array and assign the value to integer "mid".
		// This effectively allows us to split the array into two halves, the left half
		// (low to mid) and the right half (mid to high)

		// Call the mergeSort function again twice, once for the left half of the array,
		// and again for the right half
		// This step qualifies the program as being recursive, as the method is being
		// called from within itself

		mergeSort(a, low, mid); // Recursively call merge sort on the left half, which with repeat the previous
								// divide&conquer step
		mergeSort(a, mid, high); // Recursively call merge sort on the right half, which with repeat the previous
									// divide&conquer step

		int[] temp = new int[N]; // Create an empty temporary array in which to store the newly sorted elements
		int i = low, j = mid;
		// Merge two sorted sub-arrays: We compare the elements of both sub-arrays one
		// by one and place the smaller element into a temporary array
		for (int k = 0; k < N; k++) {
			if (i == mid) {
				temp[k] = a[j++];
			}

			else if (j == high) {
				temp[k] = a[i++];
			}

			else if (a[j] < a[i]) {
				temp[k] = a[j++];
			}

			else {
				temp[k] = a[i++];
			}
		}
		for (int k = 0; k < N; k++) { // Upon reaching the end of the array, the elements of the temporary array are
										// copied into the original array in the correct order
			a[low + k] = temp[k];
		}
	}

}