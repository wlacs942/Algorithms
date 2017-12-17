/*
Kim Camacho
CO Sci 942 - Discrete Structures
Due: 12/17/17
Selection Sort Algorithm

Algorithm: "Finite sequence of precise instructions for performing a computation or solving problem"

SELECT SORT
-This technique for sorting finds the smallest element in each pass and places it in the
appropiate position to get the elements in ascending or descending order.

-The selection sort algorithm searches through and sorts an array. 

Explanation:

-Each iteration, the unsorted element with the smallest (or largest) value
is moved to its proper position in the array. 

-The number of times the sort passes through the array is one less than 
the number of items in the array. 
--if we have 'n' elements then it (n-1) pass(es) to sort.
--must have for (length of array) loop

-In the selection sort, the inner loop finds the next smallest (or largest) value 
and the outer loop places that value into its proper location.

For example, during the first iteration the smallest number will be search for,
then moved to the front of the list to the "sorted out" section of the array which will no
longer be considered in subsequent iterations since it will always be smaller than the next 
smallest valued number. 
--in pass 1, smallest element is searched between a[0] to a[n-1] and swapped with a[0].
--in pass 2, smallest element is searched between a[1] to a[n-1] and swapped with a[1].

*Run code below to see example.

Notes:

Out of curiosity, I looked up how this algorithm compared and differed from the bubblesort 
algorithm and found a couple things:
1. Adjacent element is compared and swapped with bubble sort while with selectsort the smallest
element is selected and swapped with the first element.
2. Time wise, bubblesort is slower -- O(n) versus selectsort O(n2) -- making bubblesort less
efficient when compared to selectsort. 
3. But bubblesort is stable compared to selectsort.  "An algorithm is said to be stable if the elements
with the same key occurring in the same order as they were occurring before sorting in the list or array. 
Generally most stable and fast algorithms use additional memory."
4. The methord for sorting that bubblesort uses is exchanges while selectsort does as its name states, 
selects and sort.
*/


public class SelectionSortAlgorithm {  
    public static void selectionSort(int[] arr)
    {  
        //The number of times the sort passes through the array is one less than the number of items in the array each pass
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;
            
            //searches for current smallest number 
            for (int j = i + 1; j < arr.length; j++)
            {  
                if (arr[j] < arr[index]){  
                    index = j;  
                }  
            }  
            
            //places current smallest value in proper location
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
    }  
    
       
    public static void main(String a[])
    {  
        //test array
        int[] arr1 = {89,16,-3,5,27,9,2,-50};
        
        System.out.println("Unordered list of integers:");  
        for(int i:arr1)
        {  
            System.out.print(i+" ");  
        }  
        System.out.println();  
          
        selectionSort(arr1);//sorting array using selection sort  
         
        System.out.println("Ordered list of integers using SelectionSort Algorithm");  
        
        for(int i:arr1)
        {  
            System.out.print(i+" ");  
        }  
    }  
} 
