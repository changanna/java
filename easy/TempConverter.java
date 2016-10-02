
import java.util.Scanner;
// import java.text.NumberFormat;

public class TempConverter {
    public static void main (String[] args) {

	System.out.println ("\nWelcome to the Temperature Converter\n");
	Scanner sc = new Scanner (System.in);
	String choice = "y";

	while (choice.equalsIgnoreCase ("y"))
	{
		// get the input from the user
		System.out.print ("Enter degree in Fahrenheit: ");
		double fdegree = sc.nextDouble();

		// calculate the result
		String cdegree = converter (fdegree);

		// display the result
    		System.out.println("Degrees in Celsius: " + cdegree );

		// see if the user wants to continue
		System.out.print ("\nContinue? (y/n): ");
		choice = sc.next();
		System.out.println();
	}
    }
    private static String converter ( double fdegree )
    {
	double cdegree = ((fdegree - 32)*5) / 9;
	String cdegreeStr = String.format ("%.2f", cdegree);
	if ( cdegree == (int)cdegree ) {
		cdegreeStr = String.valueOf ((int) cdegree);
	}
	return cdegreeStr;
    }
}
