#include <iostream>
using namespace std; 

void change(int[], int[], int, int);

int main()
{
	int changeQuant;
	int numDenom;
	 
	// Dynamically allocated data allows the user to enter
	// any number of coin denominations.
	int* coinDenom;
	int* numCoins;

	cout << "\n Enter the number of coin denominations: ";
	cin  >> numDenom;

	coinDenom = new int[numDenom];	// Array holding the values of the coin denominations
	numCoins  = new int[numDenom];	// Array holding the number of coins per denomination

	cout << "\n Enter the values for coin denominations, "
		 << "\n in order of decreaing value.\n";

	// Loop runs for the number of coin denominations entered and
	// receives the value of each coin denomination
	for (int i = 0; i < numDenom; i++)
	{
		cout << "\n Enter the value for coin denomination " << (i + 1) << ": ";
		cin >> coinDenom[i];
	}

	cout << "\n Enter a positive value of change to receive, in cents: ";
	cin >> changeQuant;

	change(coinDenom, numCoins, changeQuant, numDenom);

	cout << "\n The change is as follows: \n";

	// Loop displays the number of coins per denomination
	for (int i = 0; i < numDenom; i++)
	{
		// Will only display the number of coins if coins are greater than 0
		if (numCoins[i] > 0)		
		{
			cout << "\n\t " << coinDenom[i] << "-cent coins: "
				 << numCoins[i];
		}
	}

	return 0;
}


// Greedy algorithm.
void change(int cd[], int nc[], int cq, int nd)
{
	for (int i = 0; i < nd; i++)
	{
		int coinCount = 0;		// The variable counts the number of coins.
		while (cq >= cd[i])
		{
			coinCount++;			// Adds one coin
			cq = cq - cd[i];		// Remaining amount of change
		}
		// Stores the number of coins for the current denomination
		// in the numCoins array.
		nc[i] = coinCount;		
	}
}
