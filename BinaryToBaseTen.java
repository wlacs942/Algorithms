// This program asks the user to enter a binary number such as 1011011, and validates that the entry is a binary number.
// This program converts and displays the binary number to its base 10 equivalent.

import java.util.Scanner;
import java.io.*;

public class BinaryToBaseTen
{
        public static void main(String[] args) throws IOException
        {
            Scanner input = new Scanner(System.in);
           
            char go = 'y'; // Declares and initializes char variable

            while (go == 'y' || go == 'Y') // Allows the user to enter both y and Y
            {
                input = new Scanner(System.in);
                System.out.print("Enter a binary number: "); // Prompts the user to enter a binary number
                String binaryNumber = input.nextLine(); // Reads the input it as string

                if ( binaryNumber.length() > 1 && checkBinaryNumber(binaryNumber) && blankCheck(binaryNumber)) // checks if the input is a binary number using checkBinaryNumber method
                {
                    System.out.println("You entered " + binaryNumber);
                    int finalAnswer = binaryToBaseTen(Integer.parseInt(binaryNumber)); // Converts a binary number to base 10 equivalent using BinaryToBaseTen method
                    System.out.println("Its base 10 equivalent is " + finalAnswer + "\n");
                }
                
                else
                {
                    System.out.println("You have entered an invalid input. You must enter a binary number.\n");
                }

                System.out.print("Would you like to continue? (Y or N): "); // Asks the user to continue or not
                go = input.next().charAt(0); // Returns the first charater of the next String object.
                System.out.print("\n");
            }

            System.out.println("Thank you. \n");
        }

        public static int binaryToBaseTen(int binaryNumber) // Converts a binary number to its base 10 equivalent
        {
            int base = 0; // Declares and initizlies base and power
            int power = 0;

            while (binaryNumber != 0)
            {
                base += (binaryNumber % 10) * Math.pow(2, power); // Calculates a binary number to its base 10 equivalent
                binaryNumber = binaryNumber / 10;
                power ++; // Increase the power by one each time
            }
            return base; // Returns to base to calculate
        }

        public static boolean checkBinaryNumber(String binaryNumber) //Checks if BrinaryNumber string only consists of 1 and 0
        {
            for (int i = 0; i < binaryNumber.length(); i++)
            {
                if (binaryNumber.charAt(i) != '0' && binaryNumber.charAt(i) != '1') // Returns false if input is something other than 1 and 0
                    return false;
            }
            return true;
        }

        public static boolean blankCheck(String binaryNumber)
        {
            for (int i = 0; i < binaryNumber.length(); i++) // Reuturns false if there is at least 1 space in the String binaryNumber
            {
                char c = binaryNumber.charAt(i);
                if (c == ' ')
                    return false;
            }
            return true; // No space returns to true
        }
}
