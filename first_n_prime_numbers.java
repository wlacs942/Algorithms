/*
Java program to display first n prime numbers.
This program will display the first n prime numbers, n being the number entered by the user.

Example:
Enter the value of n:
15
First 15 prime numbers are:
2
3
5
7
11
13
17
19
23
29
31
37
41
43
47
*/


import java.util.Scanner;

class PrimeNumberDemo
{
   public static void main(String args[])
   {
      int n;
      int status = 1;
      int num = 3;
      //For capturing the value of n
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the value of n:");
      //The entered value is stored in the var n
      n = scanner.nextInt();
      if (n >= 1)
      {
         System.out.println("First "+n+" prime numbers are:");
         //2 is a known prime number
         System.out.println(2);
      }

      for ( int i = 2 ; i <=n ;  )
      {
         for ( int j = 2 ; j <= Math.sqrt(num) ; j++ )
         {
            if ( num%j == 0 )
            {
               status = 0;
               break;
            }
         }
         if ( status != 0 )
         {
            System.out.println(num);
            i++;
         }
         status = 1;
         num++;
      }         
   }
}
