/*
Julio Aguilar
Bubble Sort
Cs942 class project
*/

#include<iostream>
using namespace std;

//prototypes
void sort(int values[], int m);
bool search(int value, int values[], int m);

int main()
{
	//Declorations
	int nums[] = {41, 39, 43, 40, 52, 63, 88, 32, 54, 66, 12, 16, 5, 8}; //array of integers(int size must equal the amount of elements)
	int size = 14; //Size of array (needs to be adjusted whenever the number of elements in array nums[] is changed)
	
	//Starts sort
	sort(nums, size);

	//Prints Sorted Array of nums[]
	for (int i = 0; i < size; i++)
	{
		if (i < (size - 1))
			cout << nums[i] << " \n";
	} cout << endl;

	//Return Success
	system("pause");
	return 0;
}

//////////////////////////////////////////////////////////////////////////////////////////
//Fucntion Prototype(s)
//////////////////////////////////////////////////////////////////////////////////////////
//Function to sort
void sort(int values[], int s)
{
	//Temp Declorations
	int counter; //used to determine loop restart
	int holder;  //value holder when when swapping arrays elements

	do //Sort
	{
	//initialize counter here to allow loop entrance
	counter = 0; //resets to 0 when condition fails to exit loop
		
		//start sort loop
		for (int i = 0; i < (s - 1); i++)
		{
		if (values[i] > values[i + 1])
		{                               
		holder = values[i];         //////////
		values[i] = values[i + 1];  //Swapping
		values[i + 1] = holder;     //////////
		counter++;                  //prevents loop exit if two elements are swapped
		}
		}
	} while (counter != 0); //condition required to exit loop
}
