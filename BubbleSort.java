import java.util.*;
import java.io.*;

/** Bubble sort program will sort a sequnce of numbers by comparing
their value one by one and swapping them into the correct position **/






class BubbleSort {
// Sorts the sequence 
void Sorter (int numbers[]) {
	
	int Num = numbers.length; //Gets the length of the array
	
	for (int i = 0; i < Num - 1; i++)
		for (int j = 0; j < Num - i - 1; j++)
			if (numbers[j] > numbers [j+1]) {
				
				int temp = numbers[j];
				numbers[j] = numbers[j+1];
				numbers[j+1] = temp;
				
			}
	}
//Prints the the sorted sequence 
	void printSort( int numbers[]) {
		
		int n = numbers.length;
		
		for (int i = 0; i < n; ++i)
			System.out.println( numbers[i] + " ");
	}
	
	public static void main(String args[]) {
	
		BubbleSort Sort = new BubbleSort();
		int numbers[] = {22, 5, 21, 66, 91, 42, 7};
		Sort.Sorter(numbers);
		System.out.print( "Array Sorted: ");
		Sort.printSort(numbers);
	}
	
}