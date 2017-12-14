/*
Frank Ian Iskra
CO Sci 942 - Discrete Structures
Due: 12/17/17
Bubble Sort Algorithm

Algorithm: Finite sequence of precise instructions for performing a computation or solving problem
1. Input: Input from Specified Set
2. Output: For each set of input values, there is an output from specified set
3. Definiteness: Each step must be defined precisely
4. Correctness: Produce Correct Output Values for each input
5. Finiteness: Returns desired output after finite number of steps
6. Effectivness: Perform each step of algorithm in finite amount of time
7. Generality: Applicable to all in this form, not just particular set
*/
public class BSort{

	public static void main(String[] args){
		//procedure
		int[] anArray = {51, 87, 13, 22, 74, 36, 11, 64, 96, 29};
		BubbleSort(anArray);//pass in the anArray
		for(int i = 0; i < anArray.length; i++){//loop array to last index
			System.out.print(anArray[i] + " ");//prints out each array
		}

	}

	public static void BubbleSort(int[] a){
		//procedure
		for(int i = a.length - 2; i > 0; i--){//outer loop to shorten from top of list
			
			for(int j = 0; j <= i; j++){//inner loop bottom element with next above
				
				if(a[j] > a[j+1]){
					int temp = a[j];//stores j in a array
					a[j] = a[j+1];//overwrites a[j] by swap
					a[j+1] = temp;//replaces
				}
			}
		}

	}
}