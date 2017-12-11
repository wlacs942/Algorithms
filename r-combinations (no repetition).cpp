// This algorithm determines the number of r-combinations of a set with
// n elements, where n is a nonnegative integer and r is an integer with
// 0 <= r <= n, and where repetition is not allowed.  More succinctly, this 
// algorithm calculates 
// C(n, r) =  C(n, n - r) = (n!)/((r!)((n - r)!)).  
// One application of this algorithm, is the calculation of the number 
// of the different hands of r cards, dealt from a deck of 52 (n) cards.


#include <iostream>
using namespace std;

int factorial(int startVal, int stopVal);

int main()
{
	int r,  // number of elements per r-combination
		n,	// number of elements
		c;  // number of combinations

	cout << "\n Enter the number of elements (n), where n is a "
		<< "\n non-negative integer: ";
	cin >> n;

	cout << "\n Enter the number of r combinations, from the "
		<< "\n set of n elements, where 0 <= r <= n : ";
	cin >> r;

	// In order to avoid overloading the compiler's capacity for the
	// largest integer, through the use of the factorial function for 
	// (n! / (n - r)!), cancellation of like terms in the numerator 
	// and denominator begins before the use of the factorial function, 
	// through the use of stop value, ((n - r) + 1)), which is the last 
	// value calculated by the factorial function, before cancelation of 
	// terms. For values where there is no cancellation (such as the 
	// calculation of r!), the stop value is equal to 1.

	c = factorial(n, ((n - r) + 1)) / factorial(r, 1);

	cout << "\n There are " << c << " possible combinations of "
		<< r << " elements," << "\n from a set of " << n << " elements.";

	return 0;
}


// Due to the need for a stop value in the factorial function, 
// an iterative approach must be used instead of a recursive one.

int factorial(int startVal, int stopVal)
{
	int f = 1;  // f is the placeholder for the value
				// returned by the factorial function.
				// It is initialized to 1, in order to
				// avoid multiplication by zero, if the
				// start value is greater than 1.

	if (startVal == 0)
		f = 0;
	else if (startVal == 1)
		f = 1;
	else
	{
		for (int i = startVal; i >= stopVal; i--)
			f *= i;
	}
	return f;
}
