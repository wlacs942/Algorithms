// This program finds the second largest number in a list
//Java program to find second largest number in an array
 //Algorithim
	//Initialize highest and secondHighest with minimum possible value.
	//Iterate over array.
	//If current element is greater than highest
	//Assign secondHighest = highest
	//Assign highest = currentElement
	//Else if current element is greater than secondHighest
	//Assign secondHighest =current element.
public class FindSecondLargestMain {
 public static void main(String args[])
 {
 int[] arr1={7,5,6,1,4,2};
 int secondHighest=findSecondLargestNumberInTheArray(arr1);
 System.out.println("Second largest element in the array : "+ secondHighest);
 }
 
 public static int findSecondLargestNumberInTheArray(int array[])
 {
 // Initialize these to the smallest value possible
 int highest = Integer.MIN_VALUE;
 int secondHighest = Integer.MIN_VALUE;
 
 // Loop over the array
 for (int i = 0; i < array.length; i++) {
 
 // If current element is greater than highest
 if (array[i] > highest) {
 
 // assign second highest element to highest element 
 secondHighest = highest;
 
 // highest element to current element
 highest = array[i];
 } else if (array[i] > secondHighest)
 // Just replace the second highest
 secondHighest = array[i];
 }
 
 
 // After exiting the loop, secondHighest now represents the second
 // largest value in the array
 return secondHighest;
 }
}