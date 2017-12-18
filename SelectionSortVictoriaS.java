/*
 * Victoria Svyrydyuk
 * Group Project
 * COS 942 Fall 2017
 * Selection Sort Algorithm
 */
//package selectionsortvictorias;

public class SelectionSortVictoriaS {

    void sortInAscendingOrder(int array[]){
	for (int i=0; i<array.length-1; i++){
	//Find the smallest number in the unsorted array
            int indexOfMinNum = i;
            for (int j = i+1; j < array.length; j++){
                if (array[j] < array[indexOfMinNum])
                    indexOfMinNum = j;
            }
        //Swap the smallest number found to the front of the array
            int temp = array[indexOfMinNum];
            array[indexOfMinNum] = array[i];
            array[i] = temp;
	}
    }

    void printSortedArray(int array[]){
	for (int i=0; i<array.length; i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        SelectionSortVictoriaS obj = new SelectionSortVictoriaS();
        int array[] = {56,27,20,10,1,4,8,90,45,100,16,3};
        
        System.out.println("Unsorted array:");
        //Print the given unsorted array
        for (int i=0; i<array.length; i++)
            System.out.print(array[i]+" ");
        System.out.println();
            
        obj.sortInAscendingOrder(array);
        System.out.println("Sorted array:");
        obj.printSortedArray(array);
    } 
}

/*
Output of the program
run:
Unsorted array:
56 27 20 10 1 4 8 90 45 100 16 3 
Sorted array:
1 3 4 8 10 16 20 27 45 56 90 100 
BUILD SUCCESSFUL (total time: 0 seconds)
*/
