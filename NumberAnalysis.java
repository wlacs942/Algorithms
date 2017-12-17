/*Programmer: Kevin Bernal-Rivera
  Date: December 17, 2017
  Purpose: Getting numbers separated by commas and finding the highest and lowest numbers, as well as the total and average. */

import javax.swing.JOptionPane;
import java.util.*; //Imported to use the ArrayList and StringTokenizer classes.
import java.text.DecimalFormat; //To format the console output.


public class NumberAnalysis 
{

    public static void main(String[] args) 
    {
        //Declaring string that will hold the original string of numbers. Instantiating an integer ArrayList.
        //Instantiating the DecimalFormat class to format the average of the numbers. Will round to the nearest hundredth.
        String stringOfNumbers;
        ArrayList<Integer> userNumbers = new ArrayList<Integer>();
        DecimalFormat formatter = new DecimalFormat("#0.00");
        
        //Asking the user for numbers. String entered by the user is held in the stringOfNumbers variable.
        stringOfNumbers = JOptionPane.showInputDialog("Enter a series of numbers separated by commas");
        
        //Creating an instance of the StringTokenizer, which passes the number string as an argument and sets a comma as the delimiter.
        StringTokenizer strToken = new StringTokenizer(stringOfNumbers, ",");
    
        //Loop continues until no tokens are left in the string. Adding the converted token to the userNumber ArrayList.
        while(strToken.hasMoreTokens())
            userNumbers.add(Integer.parseInt(strToken.nextToken()));

        //The following lines get and display information.
        JOptionPane.showMessageDialog(null, "The lowest number entered is: " + lowestNumber(userNumbers));
        
        JOptionPane.showMessageDialog(null, "The highest number entered is: " + highestNumber(userNumbers));
        
        JOptionPane.showMessageDialog(null, "The total of the numbers entered is: " + total(userNumbers));
        
        JOptionPane.showMessageDialog(null, "The average of the numbers entered is: " + formatter.format(average(userNumbers)));
                 
    }
    
    public static int lowestNumber(ArrayList<Integer> numberList)
    {
        //Setting lowest number to the first array element. Finds the lowest number using an enhanced for loop.
        int lowestNumber = numberList.get(0);
        for(int i: numberList)
            if(i < lowestNumber)
                lowestNumber = i;
        
        return lowestNumber;
    }
    
    public static int highestNumber(ArrayList<Integer> numberList)
    {
        //Setting highest number to the first array element. Finds the highest number using an enhanced for loop.
        int highestNumber = numberList.get(0);
        for(int i: numberList)
            if(i > highestNumber)
                highestNumber = i;
        
        return highestNumber;
    }
    
    public static int total(ArrayList<Integer> numberList)
    {
        //Setting accumulator to 0. Getting total of the numbers in the array using an enhanced for loop.
        int total = 0;
        for(int i: numberList)
            total += i;
        
        return total;
    }
    
    public static double average(ArrayList<Integer> numberList)
    {
        //The total of the ArrayList is divided by the casted value of the size of the array. Allows for a double to be returned.
        double average = total(numberList)/(double)numberList.size();
        return average;
    }
    
}//End of NumberAnalysis
