/*
Morris Zieve

WLAC COS 942 16796 Algorithm Implementation

Heap Sort Algorithm

A sorting algorithm that works by first organizing the data to be sorted into a special type of binary tree called a heap. The heap itself has, by definition, the largest value at the top of the tree, so the heap sort algorithm must also reverse the order. It does this with the following steps:

  1. Remove the topmost item (the largest) and replace it with the rightmost leaf. The topmost item is stored in an array.

  2. Re-establish the heap.

  3. Repeat steps 1 and 2 until there are no more items left in the heap.

The sorted elements are now stored in an array.

A heap sort is especially efficient for data that is already stored in a binary tree. In most cases, however, the quick sort algorithm is more efficient.
*/

// Heap Sort
public class HeapSort
{
	public void sort(int numberArray[])
	{
		int n = numberArray.length;

		// Build Heap
		for (int i = n / 2 - 1; i >= 0; i--)
			heap(numberArray, n, i);

		// Extract Element
		for (int i=n-1; i>=0; i--)
		{
			// Move Root
			int temp = numberArray[0];
			numberArray[0] = numberArray[i];
			numberArray[i] = temp;

			// Call Max
			heap(numberArray, i, 0);
		}
	}

	// Heap Subtree
	void heap(int numberArray[], int n, int i)
	{
		int largest = i; // Declare Large Root
		int l = 2*i + 1; // Left
		int r = 2*i + 2; // Right

		// Left > Root
		if (l < n && numberArray[l] > numberArray[largest])
			largest = l;

		// Right > Root
		if (r < n && numberArray[r] > numberArray[largest])
			largest = r;

		// Large Not Root
		if (largest != i)
		{
			int swap = numberArray[i];
			numberArray[i] = numberArray[largest];
			numberArray[largest] = swap;

			heap(numberArray, n, largest);
		}
	}

	// Print Array Size
	static void printArray(int numberArray[])
	{
		int n = numberArray.length;
		for (int i=0; i<n; ++i)
			System.out.print(numberArray[i]+" ");
		System.out.println();
	}

	// Driver Program
	public static void main(String args[])
	{
		int numberArray[] = {12342342, 12341, 1352, 5, 62352, 4527};
		int n = numberArray.length;

		HeapSort ob = new HeapSort();
		ob.sort(numberArray);

		System.out.println("Order: ");
		printArray(numberArray);
	}
}
