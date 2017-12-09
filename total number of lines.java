import java.util.Scanner;
 
public class Project {
 
 public static void main(String[] args) {
 
  System.out.print("Enter the number of lines:");
  Scanner input = new Scanner(System.in);
 
  // get the total number of lines n.
  int n = input.nextInt();
 
  // Loop through the lines from 1 to n
  for (int i = 1; i <= n; i++) {
   // printing spaces, 4 at a time from j=0 to j= n-i
   for (inat j = 1; j <= (n - i); j++) {
    System.out.print("    ");
   }
 
   // Printing number increamentally from 0 to i-1
   for (int j = 0; j < i; j++) {
    System.out.printf("%4d", (int) Math.pow(2, j));
   }
 
   // Printing number decreamentally from i-2 to 0
   for (int j = i - 2; j >= 0; j--) {
    System.out.printf("%4d", (int) Math.pow(2, j));
   }
   System.out.println();
 
  }
 
 }
 
}
