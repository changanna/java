
import java.util.Scanner;
// import java.text.NumberFormat;

public class TravelCalc {
    public static void main (String[] args) {

	System.out.println ("\nWelcome to the Travel Time Calculator\n");
	Scanner sc = new Scanner (System.in);
	String choice = "y";

	while (choice.equalsIgnoreCase ("y"))
	{
		// get the input from the user
		System.out.print ("Enter miles:\t\t");
		double miles = sc.nextDouble();
		System.out.print ("Enter miles per hour:\t");
		double milesPerHour = sc.nextDouble();

		// calculate the result
		double travelTime = miles / milesPerHour;
		String [] travelHrMin = converter (travelTime);

		// display the result
		System.out.println ("\nEstimated travel time");
		System.out.println ("Hours:   " + travelHrMin[0]);
		System.out.println ("Minutes: " + travelHrMin[1]);

		// see if the user wants to continue
		System.out.print ("\nContinue? (y/n): ");
		choice = sc.next();
		System.out.println();
	}
    }
    private static String [] converter (double time)
    {
	String[] hourMin = new String[2];
	hourMin[0] = String.valueOf ((int) time);
	double mins = ( time - (int) time ) * 60;
	hourMin[1] = String.valueOf ((int) mins);
	return hourMin;
    }
}
