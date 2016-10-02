
import java.util.Scanner;
// import java.text.NumberFormat;

public class CoinCalc {
    public static void main (String[] args) {

	System.out.println ("\nWelcome to the Change Calculator\n");
	Scanner sc = new Scanner (System.in);
	String choice = "y";

	while (choice.equalsIgnoreCase ("y"))
	{
		// get the input from the user
		System.out.print ("Enter number of cents (0-99): ");
		byte cents = sc.nextByte();

		// calculate the result
		String [] coins = converter (cents);

		// display the result
    		System.out.println("Quarters: " + coins[3] );
    		System.out.println("Dimes:    " + coins[2] );
    		System.out.println("Nickels:  " + coins[1] );
    		System.out.println("Pennies:  " + coins[0] );

		// see if the user wants to continue
		System.out.print ("\nContinue? (y/n): ");
		choice = sc.next();
		System.out.println();
	}
    }
    private static String [] converter ( byte cents )
    {
	String[] coins = new String[4];
	int quarters = (int) cents / 25;
	int dimes = (int) ( cents - 25 * quarters ) / 10;
	int nickles = (int) ( cents - 25 * quarters - 10 * dimes ) / 5;
	int pennies = cents - 25 * quarters - 10 * dimes - 5 * nickles;
	coins[3] = String.valueOf (quarters);
	coins[2] = String.valueOf (dimes);
	coins[1] = String.valueOf (nickles);
	coins[0] = String.valueOf (pennies);
	return coins;
    }
}
