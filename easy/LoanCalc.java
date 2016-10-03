
import java.util.Scanner;
import java.text.NumberFormat;
import java.lang.Math;
import java.util.InputMismatchException;

public class LoanCalc
{
    public static void main (String[] args) 
    {
	MortgagePaymentCalculator item = new MortgagePaymentCalculator ();
	item.calcLoopAPI();
    }
}

class MortgagePaymentCalculator {
   String choice = "y";

   public MortgagePaymentCalculator () {
	System.out.println ("\nWelcome to the Loan Calculator\n");
	greeting();
   }
   void greeting () {
	System.out.println ("DATA ENTRY");
   }

   public static double getDouble (Scanner sc, String prompt) {
 	double d = 0.0;
 	boolean isValid = false;
 	while (isValid == false)
 	{
 		System.out.print(prompt);
 		if (sc.hasNextDouble())
 		{
 			d = sc.nextDouble();
 			isValid = true;
 		}
 		else {
 			System.out.println(
 				"Error! Invalid decimal value. Try again.");
 		}
 		sc.nextLine(); // discard any other data
 	}
 	return d; 
   }

   public static double getDoubleWithin (
	Scanner sc, String prompt, double min, double max ) 
   {
	double d = 0.0;
	boolean isValid = false;
	while (isValid == false) {
        	d = getDouble (sc, prompt);
        	if (d <= min) {
            		System.out.println(
                		"Error! Number must be greater than " + 
                		min + ".");
        	}
        	else if (d >= max) {
            		System.out.println(
                		"Error! Number must be less than " +
                		max + ".");
        	} 
		else
        		isValid = true;
	}
	return d; 
   }

   public static int getInt (Scanner sc, String prompt) {
 	int d = 0;
 	boolean isValid = false;
 	while (isValid == false)
 	{
 		System.out.print(prompt);
 		if (sc.hasNextInt())
 		{
 			d = sc.nextInt ();
 			isValid = true;
 		}
 		else {
 			System.out.println(
 				"Error! Invalid integer value. Try again.");
 		}
 		sc.nextLine(); // discard any other data
 	}
 	return d; 
   }

   public static int getIntWithin (
	Scanner sc, String prompt, int min, int max ) 
   {
	int d = 0;
	boolean isValid = false;
	while (isValid == false) {
        	d = getInt (sc, prompt);
        	if (d <= min) {
            		System.out.println(
                		"Error! Number must be greater than " + 
                		min + ".");
        	}
        	else if (d >= max) {
            		System.out.println(
                		"Error! Number must be less than " +
                		max + ".");
        	} 
		else
        		isValid = true;
	}
	return d; 
   }
 
   public static double calculateMonthlyPayment(
	double loanAmount, int loanYears, double interestRate) {
       
	// Convert interest rate into a decimal eg. 6.5% = 0.065
	interestRate /= 100.0;
       
	// Monthly interest rate is the yearly rate divided by 12
	double monthlyRate = interestRate / 12.0;
       
	// The length of the term in months is the number of years times 12
	int totalMonths = loanYears * 12;
       
	double monthlyPayment = 
		(loanAmount * monthlyRate) / 
		(1 - Math.pow(1 + monthlyRate, -totalMonths));
       
	return monthlyPayment;
   }

   public void calcLoopAPI () {
	while (choice.equalsIgnoreCase ("y")) {
		calcOnceAPI ();
		askYesNoChk ();
		System.out.println();
	}
   }

   public boolean askYesNo () {
		Scanner sc = new Scanner (System.in);
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

   public void calcOnceAPI () {

	Scanner scanner = new Scanner(System.in);
	double loanAmount;
	double loanInterest;
	int loanYears;
 
	// Prompt user for details of loan
	String prompt = "Enter loan amount:\t\t";
	loanAmount = getDoubleWithin (scanner, prompt, 0.0, 1000000.0);
	prompt = "Enter yearly interest rate:\t";
	loanInterest = getDoubleWithin (scanner, prompt, 0.0, 100.0);
	prompt = "Enter number of years:\t\t";
	loanYears = getIntWithin (scanner, prompt, 0, 100);
	double monthlyPayment = 
		calculateMonthlyPayment(loanAmount, loanYears, loanInterest);
	System.out.println("");
	System.out.println("FORMATTED RESULTS");
	prtout (loanAmount, loanYears, loanInterest, monthlyPayment);
   }

   public void prtout (
	double loanAmount, int loanYears, double loanInterest,
	double monthlyPayment
	) {
		display ("loanAmount", loanAmount);
		display ("loanInterest", loanInterest);
		display ("Number of years:\t\t", loanYears);
		display ("monthlyPayment", monthlyPayment);
   }

   public void displayH (String s) {
		System.out.print (s + "\t");
   }

   public void display (String s, int d) {
		System.out.print (s + d);
		System.out.println ("");
   }

   public void display (String s, double d) {
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	NumberFormat interest = NumberFormat.getPercentInstance();

	interest.setMinimumFractionDigits(2);
	
		if ( s == "loanAmount" ) {
			displayH ("Loan amount:\t\t");
			System.out.println (currency.format(d));
		} else if ( s == "loanInterest" ) {
			displayH ("Yearly interest rate:\t");
			// System.out.println (interest.format(d));
			System.out.println (percent2str(d));
		} else if ( s == "loanYears" ) {
			displayH ("Number of years:\t\t");
			System.out.println ((int)d);
		} else if ( s == "monthlyPayment" ) {
			displayH ("Monthly payment:\t");
			System.out.println (currency.format(d));
		} else {
			System.out.println ("Error!");
		}
   }

   private static String percent2str (double n) 
   {
		String n2Str;
		if ( n == (int)n ) {
			n2Str = String.valueOf ((int)n);
		} else {
			// n2Str = String.format ("%f",n) + "%";
			n2Str =  n + "%";
		}
		return n2Str;
   }

}    


