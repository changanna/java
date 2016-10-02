
import java.util.Scanner;
// import java.text.NumberFormat;

public class GeoCalc {
    public static void main (String[] args) {

	System.out.println ("\nWelcome to the Area and Perimeter Calculator\n");
	Scanner sc = new Scanner (System.in);
	String choice = "y";

	while (choice.equalsIgnoreCase ("y"))
	{
		// get the input from the user
		System.out.print ("Enter length:\t");
		double rectangleLength = sc.nextDouble();
		System.out.print ("Enter width:\t");
		double rectangleWidth = sc.nextDouble();

		// calculate the area
		double rectangleArea = rectangleLength * rectangleWidth;
		// calculate the perimeter
		double rectanglePerimeter = 2 * rectangleLength + 2 * rectangleWidth;

		// display the result
		System.out.println ("Area:\t\t" + rectangleArea);
		System.out.println ("Perimeter:\t" + rectanglePerimeter);

		// see if the user wants to continue
		System.out.print ("\nContinue? (y/n): ");
		choice = sc.next();
		System.out.println();
	}
    }
    private static double calculateArea (
	double length,
	double width)
    {
	double area = length * width;
	return area;
    }
}
