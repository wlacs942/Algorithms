/*	Title:	SmallestNumber 
 *	Name :	Nancy Rosa
 *	Description: Program has user enter inputs values for two arrays of the size 8. 
 *	Then finds and displays the smallest number which is common to both arrays.
 *	
 */

import java.util.Scanner;			// Needed for Scanner Class

public class SmallestNumber
{

	public static void main(String[] args) 
	{
		final int ROWS = 2;					// Number of arrays
		final int COLUMNS = 8;				// Array size.
		
		// 2d array with rows representing the list of values
		// each row holds elements(columns).
		int[][] values = getValues(ROWS, COLUMNS); //calls the getValues method sending number of rows and columns as parameters
		
		//display arrays
		System.out.println("_______________________________");
		System.out.println("*List of Values:");
		displayArray(values); // calls the displayArray method to loop through the arrays and display its elements
		
		// sort rows numerically
		for(int index = 0; index < ROWS; index++)
			selectionSort(values[index]); // calls selection sort method sending elements of the array as parameters
		
		//display arrays(ascending order).
		System.out.println("*Values in ascending order:");
		displayArray(values);
		
		// find common lowest value.
		int results = -1,x;
		for(x = 0; x < (ROWS-1); x++)								// loops through rows 
		{
			int y = 0;
			do
			{
				results = sequentialSearch(values[x+1],values[x][y]);// search current rows elements for common lowest value.
				y++;
			}
			while(results == -1 && y < COLUMNS);					// loop continues until common value is found or until all columns have been searched.
		}
		if(results == -1)  // displays results of search.
			System.out.println("\nThere is no common values!");
		else
			System.out.println("\nThe lowest common value in " + ROWS + " arrays is " + values[x][results]); // lowest common value displayed.
	}	
	
	//getValues method ask the user to fill the arrays with values.
	public static int[][] getValues(int Row,int Col)
	{
		// 2d array with rows representing the list of values
		// each row hold elements(columns).
		int[][] value = new int[Row][Col];
				
		// Creates a Scanner object for input.
		Scanner keyboard = new Scanner(System.in);
		
		// Display an introduction  to the program.
		System.out.println("This program finds the smallest value"
				+ "\nthat is common in " + Row + " arrays of size " + Col + ".");
		System.out.println("Enter the following values to fill the arrays:\n");
		
		// loop to fill rows and columns.
		for(int row = 0; row < Row; row++) // loops through till all arrays are filled
		{
			for(int col = 0; col < Col; col++) // loops to fill one array.
			{
				System.out.printf("Array %d, Value %d: ",(row+1),(col+1));
				value[row][col] = keyboard.nextInt(); //fill array with elements
			}
			System.out.println();
		}
		keyboard.close();
		return value;
	}
	
	//SelectionSort method arranges array elements into ascending order.
	public static void selectionSort(int[] array)
	{
		int startScan, index, minIndex, minValue;
		for(startScan = 0; startScan < (array.length-1); startScan++)
		{
			minIndex = startScan; // set initial minimum index
			minValue = array[startScan]; // set current element as initial minimum value.
			for(index = (startScan + 1); index < array.length; index++)
			{
				if(array[index] < minValue) // is smaller value present set as new minimum value and index.
				{
					minValue = array[index]; 
					minIndex = index; 
				}
			}
			array[minIndex] = array[startScan];
			array[startScan] = minValue;
		}
	}
	
	// sequentialSearch method search a array for a specific value and returns the 
	// subscript of the value when found or -1 if not found.
	public static int sequentialSearch(int[]array, int value)
	{
		int index = 0;			// loop starting variable
		int element = -1;		// default subscript of element 
		boolean found = false;	// default flag indicating search results
		
		while((!found) && (index <array.length))
		{
			if(array[index] == value)
			{
				found = true;		// change values when found
				element = index;
			}
			index++;
		}
		return element;
	}
	
	// displayArray method displays the array elements.
	public static void displayArray(int[][] array)
	{
		//display arrays
		for(int row = 0; row < array.length; row++)
		{
			for(int col = 0; col < array[row].length;col++)
			System.out.print(array[row][col] +" ");
			System.out.println();
		}
	}
}