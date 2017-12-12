package algorithm.quickSort;
/*This is the Quick Sort algorithm
 * it sorts a list by splitting it up based on a pivot point then it 
 * puts numbers greater than the pivot on one side and those smaller 
 * on the other side swapping them from one side to the other until 
 * the list is fully sorted*/
import java.util.Random;

public class quickSortMain {
	
	private int[] numbers;
	private int length;
	
	public void sort(int[] values) {
		if(values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		length = values.length;
		quickSorter(0, length - 1);
	}
	
	private void quickSorter(int leftIndex, int rightIndex) {
		int left = leftIndex;
		int right = rightIndex;
		int pivot = numbers[leftIndex + (rightIndex - leftIndex) / 2];
		
		while(left <= right ) {
			while(numbers[left] < pivot) {
				left++;
			}
			while(numbers[right] > pivot) {
				right--;
			}
			if(left <= right) {
				swap(left, right);
				left++;
				right--;
			}
		}
		if(leftIndex < right) {
			quickSorter(leftIndex, right);
		}
		if(left < rightIndex) {
			quickSorter(left, rightIndex);
		}
	}
	//perform the swap used above
		private void swap(int left, int right) {
			int temp = numbers[left];
			numbers[left] = numbers[right];
			numbers[right] = temp;
		}
	//display the lists
	public void displaySorted(int[] values) {
		System.out.print("[");
		for(int i = 0; i < values.length; i++) {
			if(i < values.length - 1)
				System.out.print(values[i] + ", ");
			else {
				System.out.print(values[i]);
			}
		}
		System.out.print("]\n");
	}

	public static void main(String[] args) {

			//create the array for the list
			int[] numbers = new int[10];
			//create instance of Random class to generate random numbers
			Random rand = new Random();
			//add random numbers to the array
			for(int i = 0; i < 10; i++) {
				numbers[i] = rand.nextInt(100);
			}
			//create instance of quickSort class
			quickSort qs = new quickSort();
			//display unsorted list
			System.out.println("The list to be sorted is: ");
			qs.displaySorted(numbers);
			//pass the array to the quickSort class
			qs.sort(numbers);
			//display sorted list
			System.out.println("The sorted list is: ");
			qs.displaySorted(numbers);
	}
}
