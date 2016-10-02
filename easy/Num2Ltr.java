
import java.util.Scanner;
// import java.text.NumberFormat;

public class Num2Ltr {
    public static void main (String[] args) {

	System.out.println ("\nWelcome to the Letter Grade Converter\n");
	Scanner sc = new Scanner (System.in);
	String choice = "y";

	while (choice.equalsIgnoreCase ("y"))
	{
		// get the input from the user
		System.out.print ("Enter numerical grade: ");
		byte score = sc.nextByte();

		// calculate the letter grade
		char grade = converter (score);

		// display the result
        	System.out.println("Letter grade: " + grade);

		// see if the user wants to continue
		System.out.print ("\nContinue? (y/n): ");
		choice = sc.next();
		System.out.println();
	}
    }
    private static char converter (byte score)
    {
	char grade;
	if (score >= 88) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 67) {
            grade = 'C';
        } else if (score >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

	return grade;
    }
}
