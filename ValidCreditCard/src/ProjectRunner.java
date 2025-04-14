
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ProjectRunner 
{
	    static String playerGuess;
	    static ArrayList<Object> cardDigits;
	    static int sum;
	    static int count = 0;

	    public static void main(String[] args)
	    {
	        greetUser();
	        processGuess(playerGuess);
	    //    readTextFile();
	        printAnswer();
	    }

	    public static void greetUser()
	    {
	        Scanner userInput = new Scanner(System.in);
	        System.out.println("Hello! I hope you have had a splendid day!");
	        System.out.println("Please Input a 16 digit credit card number to test if it is valid.");
	        playerGuess = userInput.nextLine();
	    }

	    public static void readTextFile()
	    {
	        try
	        {
	            Scanner myFile = new Scanner(new File("creditCardFile"));
	            while (myFile.hasNextLine())
	            {
	                String line = myFile.nextLine();
	          //      System.out.println("Checking from file: " + line);
	                processGuess(line);
	            }
	        }
	        catch (FileNotFoundException e)
	        {
	            System.out.println("File not found.");
	        }
	    }

	    public static void processGuess(String input)
	    {
	        cardDigits = new ArrayList<>();
	        for (int i = 0; i < input.length(); i++)
	        {
	            int digit = input.charAt(i) - '0'; 
	            cardDigits.add(digit);
	        }
	        doubleAlternatingDigits();
	        addTwoDigitsTogether();
	        addNewValues();
	        divideByTen();
	    }

	    public static void doubleAlternatingDigits()
	    {
	        for (int i = cardDigits.size() - 2; i >= 0; i -= 2)
	        {
	            int doubledValue = (int) cardDigits.get(i) * 2;
	            cardDigits.set(i, doubledValue);
	        }
	    }

	    public static void addTwoDigitsTogether()
	    {
	        for (int i = 0; i < cardDigits.size(); i++)
	        {
	            int value = (int) cardDigits.get(i);
	            if (value > 9)
	            {
	                cardDigits.set(i, (value / 10) + (value % 10));
	            }
	        }
	    }

	    public static void addNewValues()
	    {
	        sum = 0;
	        for (int i = 0; i < cardDigits.size(); i++)  
	        {
	            sum += (int) cardDigits.get(i);
	        }
	    }

	    public static void divideByTen()
	    {
	        if (sum % 10 == 0)
	        {
	            System.out.println("VALIDDDDDDD");
	            count++;
	        }
	        else
	        {
	            System.out.println("INVALID LOSER");
	        }
	        
	    }
	    
	    public static void printAnswer()
	    {
	    	System.out.println(count);
	    }
	    
	    
	}

