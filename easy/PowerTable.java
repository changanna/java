
import java.util.Scanner;
import java.text.NumberFormat;
import java.lang.Math;

public class PowerTable
{
    public static void main (String[] args) 
    {
	String choice = "y";

	PowerTableC item = new PowerTableC (9);
	while (choice.equalsIgnoreCase ("y")) 
	{
		item.askInput("an integer");
		item.calc();
		item.askYesNo();
		choice = item.choice;
	}
    }
}

class PowerTableC
{
	Scanner sc = new Scanner (System.in);
	String choice = "y";

	int num;
	public PowerTableC (int n) {
		System.out.println ("\nWelcome to the Squares and Cubes table\n");
		num = n;
	}

	public void askInput (String s) {
		// get the input from the user
		System.out.print ("Enter " + s + ": ");
		int numIn = sc.nextInt();
		num = numIn;
	}
	public void askInput (String s, double d) {
		// get the input from the user
		System.out.print ("Enter " + s + ": ");
		double numIn = sc.nextDouble();
		// num = numIn;
	}


	// while (choice.equalsIgnoreCase ("y"))
	public void calc () {

		// display the result
		System.out.println ("Number\tSquared\tCubed");
		System.out.println ("======\t=======\t=====");
		for (int i = 1 ; i <= num ; i++) {
			System.out.print (i);
			System.out.print ("\t");
			System.out.print (i*i);
			System.out.print ("\t");
			System.out.print (i*i*i);
			System.out.print ("\n");
		}
	}

	public void askYesNo () {
		// see if the user wants to continue
		System.out.print ("\nContinue? (y/n): ");
		choice = sc.next();
		System.out.println();
	}

}
