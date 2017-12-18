
/**
 *  Magic_Square_Agorithm_Project.
 * This Algorithm is to help, given an odd number from 3 to 25, to arrange the numbers from 1 to the square 
 * of the number chose in a way that the addition of all the numbers in a row, column, left diagonal 
 * and right diagonal are equal.
 * Hismark Carrera
 * Fall-2017 Discrete Mathematics Assignment
 */

import java.util.Scanner;
public class Magic_Square_Agorithm_Project
{
  
    public static void main(String[] args) { 
         System.out.println();   
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter an odd number from 3 upto 25: ");
    
    int n = input.nextInt();
  
    while(n % 2 == 0){
        System.out.println("The number you entered is not an odd number: ");
        System.out.println("Please enter an odd number: ");
        n = input.nextInt();
        }

    System.out.println("Your Magic Square will be: " + n + " by " + n);
    System.out.println("The total numbers to be arrange are: " + n*n);
    System.out.println("The Magic Number is:  " + ( n * ((n * n +1)/2)));
    System.out.println();
      int magic [][] = new int[n][n];

        int row = 0;
        int col = n/2;
        magic[row][col] = 1;

        for (int i = 2; i <= n*n; i++) {
            if (magic[(row + n -1) % n][(col + 1) % n] == 0) {
                row = (row +n - 1) % n;
                col = (col + 1) % n;
            }
            else {
                row = (row + 1) % n;
                // don't change col
            }
            magic[row][col] = i;
        }

        // print results
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (magic[i][j] < 10)  System.out.print("|  ");  // for alignment
                if ((magic[i][j] >= 10) && (magic[i][j] < 100))  System.out.print("| ");  // for alignment
                if ((magic[i][j]  >= 100) && (magic[i][j]  < 1000)) System.out.print("|");
              
                System.out.print(magic[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(); 
        // calling the function to print the sum of the diagonals
        System.out.println("The sum of main Diagonal from left(top) to right(bottom) is : " + diag1(magic));
        System.out.println("The sum of the other main Diagonal from right(top) to left(bottom) is: " + diag2(magic));
    }
    
    public static int diag1(int Z[][])
    { // function to do the sum of the first diagonal
        int size = Z[0].length;
        int s = 0;
         for ( int i =0; i < size; i++)                   
               s+= Z[i][i];
        return s;
    }
     public static int diag2(int Y[][])
    { // function to do the second diagonal
        int size = Y[0].length;
        int s = 0;
         for ( int i =0; i < size; i++)                     
               s+= Y[i][size-1];
        return s;
    }
 
  }
