
import java.util.Scanner;
import java.text.NumberFormat;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

// public class GeoCalc 
public class InterestCalc
{
    public static void main (String[] args) 
    {
	System.out.println ("\nWelcome to the Interest Calculator\n");

	Scanner sc = new Scanner (System.in);
	String choice = "y";

	while (choice.equalsIgnoreCase ("y"))
	{
		// get the input from the user
		System.out.print ("Enter loan amount:\t");
		BigDecimal loanAmount = sc.nextBigDecimal();
		System.out.print ("Enter interest rate:\t");
		BigDecimal interestRate = sc.nextBigDecimal();

		// BigDecimal Round
		loanAmount = loanAmount.setScale (0, BigDecimal.ROUND_HALF_UP);

		// calculate the result
		BigDecimal interestAmount = calculator (loanAmount , interestRate);

		// Format
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		double interestRateD = interestRate.doubleValue();

		// display the result
		System.out.println ("");
		System.out.println ("Loan amount:\t\t" + currency.format (loanAmount));
		System.out.println ("Interest rate:\t\t" + percent2str (100*interestRateD) + "%");
		System.out.println ("Interest:\t\t" + currency.format (interestAmount));

		// see if the user wants to continue
		System.out.print ("\nContinue? (y/n): ");
		choice = sc.next();
		System.out.println();
	}
    }
    private static BigDecimal calculator ( BigDecimal a, BigDecimal b )
    {
	MathContext mc = new MathContext(5);
	// BigDecimal c = new BigDecimal();
	BigDecimal c = a.multiply ( b , mc );
	return c;
    }

    private static String percent2str (double n) 
    {
	String n2Str;
	if ( n == (int)n ) {
		n2Str = String.valueOf ((int)n);
	} else {
		n2Str = String.format ("%.3f",n);
	}
	return n2Str;
    }

}
