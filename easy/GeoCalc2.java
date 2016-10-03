
import java.util.Scanner;
import java.text.NumberFormat;
import java.lang.Math;
import java.util.InputMismatchException;

public class GeoCalc2
{
    public static void main (String[] args) 
    {
	GeoCalc item = new GeoCalc ();
	item.calcSquare ();
    }
}

class GeoCalc {

	Scanner sc = new Scanner (System.in);
	String choice = "y";

	double length;
	double width;
	double area;
	double perimeter;
	double numIn;
	public GeoCalc () {
		welcome ();
	}
	public GeoCalc (double l, double w) {
		welcome ();
		length = l;
		width = w;
	}
	public void welcome () {
		System.out.println ("\nWelcome to the Area and Perimeter Calculator\n");
	}

	public boolean askInput (String s) {
		// get the input from the user
		System.out.print ("Enter " + s + ":\t");
		try {
			numIn = sc.nextDouble();
		}
		catch (InputMismatchException e) {
			sc.next();
			display ("Error", 0 );	
			return false;
		}
		if (numIn < 0) {
			display ("Error", 1 );	
			return false;
		} else if (numIn > 1000000) {
			display ("Error", 2 );	
			return false;
		} else {
		    	if ( s == "length" ) {
				setLength ();
		    	} else {
				setWidth ();
		    	}
			return true;
		}
	}
	public boolean askInputTwice () {
		while (!askInput ("length")) {
			continue;
		}
		while (!askInput ("width")) {
			continue;
		}
		return true;
	}
	public void setLength () {
		length = numIn;
	}
	public void setWidth () {
		width = numIn;
	}

	public void calc () {
		area = calcArea(length, width);
		perimeter = calcPerimeter(length, width);
	}

	public void prtout () {
		display ("Area");
		display ("Perimeter");
	}

	public void display (String s) {
		System.out.print (s + ":\t");
		if ( s == "Area" ) {
			// dispArea ();
			System.out.println ("\t" + area);
		} else if ( s == "Perimeter" ) {
			// dispPerimeter ();
			System.out.println (perimeter);
		} else {
			System.out.println ("Error!");
		}
	}

	public void display (String s, int type) {
		System.out.print (s + "! ");
		if ( type == 0 && s == "Error" ) {
			System.out.println ("Invalid decimal value. Try again.");
		} else if ( type == 1 && s == "Error" ) {
			System.out.println ("Number must be greater than 0.0");
		} else if ( type == 2 && s == "Error" ) {
			System.out.println ("Number must be less than 1000000.0");
		} else {
			System.out.println ("Unknown type!");
		}
	}

	public boolean askYesNo () {
		// see if the user wants to continue
		System.out.print ("\nContinue? (y/n): ");
		choice = sc.nextLine();
		boolean isNotYes = !(choice.equalsIgnoreCase ("y"));
		boolean isNotNo = !(choice.equalsIgnoreCase ("n"));
		boolean isEmpty = choice.isEmpty();
		if (isEmpty) {
			System.out.println ("Error! This entry is required. Try again. ");
			return false;
		} else
		if (isNotYes && isNotNo) {
			System.out.println ("Error! Entry must be 'y' or 'n'. Try again. ");
			return false;
		} else {
			return true;
		}
	}
	public void askYesNoChk () {
		while ( !askYesNo () )
		{ continue; }
	}

	public void calcSquare () {

	    while (choice.equalsIgnoreCase ("y"))
	    {
		if (askInputTwice()) {
			calc ();
			prtout ();
			sc.nextLine();
		} else {
			continue;
		}

		askYesNoChk ();
		System.out.println();
		
	    }
	}

	public double calcArea ( double length, double width ) 
	{
		double result = length * width;
		return result;
	}
	public double calcPerimeter ( double length, double width ) 
	{
		double result = 2*length + 2*width;
		return result;
	}

}
