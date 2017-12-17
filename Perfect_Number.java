/*(Perfect number) A positive integer is called a perfect number if it is equal to the sum of all of its positive divisors, excluding itself.
For example, 6 is the first perfect number because 6 = 3 + 2 + 1. The next is 28 = 14 + 7 + 4 + 2 + 1. 
There are four perfect numbers less than 10,000. 
*/
public class Perfect_Number {
 
 public static void main(String[] args) {
 
  // Loop through every number from 1 to 10000
  int sumOfDivisor = 0;
  int numberOfPerfect = 0;
 
  for (int i = 1; i <= 10000; i++) {
   // Loop through every number from 2 to n-1 , check if it is a
   // divisor of n and calculate the sum
   for (int j = 1; j < i; j++) {
    if (i % j == 0) {
     sumOfDivisor += j;
    }
   }
 
   if (sumOfDivisor == i) {
    System.out.println(i + " is a perfect number");
    numberOfPerfect++;
   }
   //reseting sum for the next loop
   sumOfDivisor = 0;
  }
  System.out.println("Total number of perfect number is "
    + numberOfPerfect);
 
 }
 
}
/*6 is a perfect number
28 is a perfect number
496 is a perfect number
8128 is a perfect number
Total number of perfect number is 4
*/
