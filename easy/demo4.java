
import java.util.Scanner;
import java.text.NumberFormat;
import java.lang.Math;
import java.util.InputMismatchException;

class Demo
{
    public static void main (String[] args) 
    {
	Scanner sc = new Scanner(System.in);
	System.out.println ("");
	System.out.println ("HOMEWORK 3 :");
	System.out.println ("============\n");
	String ask = "Enter the homework you want to run (1 or 2 or 3 or 4): ";
	double d = MyLib.askInputNum (ask, 1, 0, 5);

	switch ((int)d) {
		case 1:
			hw31();
			break;
		case 2:
			hw32();
			break;
		case 3:
			hw33();
			break;
		case 4:
			hw34();
			break;
		default:
			break;
	}
    }

    public static void hw34 ()
    {
	Num2WordsAPP item = new Num2WordsAPP ();
	while (true) {
		item.runApp();
		if ( !MyLib.askYesNoChk("Convert another number") ) { break; }
	}
    }

    public static void hw33 ()
    {
	PigLatinAPP newitem = new PigLatinAPP ();
	while (true) {
		newitem.translate();
		if ( !MyLib.askYesNoChk("Translate another line") ) { break; }
	}
    }

    public static void hw32 ()
    {
	MyLib.greeting ("to the Paradise Roller application");

	DiceRollerApp item = new DiceRollerApp();
	while (true) {
		if ( !MyLib.askYesNoChk("Roll the dice") ) { break; }
		else {item.roll();}
	}
    }

    public static void hw31 ()
    {
	MyLib.greeting ("to the Circle Tester");

	while (true) {
		String ask = "Enter radius:   ";
		double d = MyLib.askInputNum (ask, 1, 0);
		Circle item = new Circle(d);
		double c = item.getCircumference();
		MyLib.prtout ("Circumference: ", MyLib.float2Dec (c, 2) );
		double a = item.getArea();
		MyLib.prtout ("Area:          ", MyLib.float2Dec (a, 2) );

		if ( !MyLib.askYesNoChk() ) { break; }
	}
	int count = Circle.getObjectCount();
	System.out.println ("Goodbye. You created " + count + " Circle object(s)." );
	
    }
}

class Num2WordsAPP {
	public Num2WordsAPP () {
		MyLib.greeting ("to the Number to Word Converter.");
	}
	public void runApp () {
		String ask = "Enter the number you want to convert to words: ";
		double d = MyLib.askInputNum (ask, 1, -1, 10000);
		Num2Words item = new Num2Words();
		String result = item.conv((int)d);
		if (result.isEmpty()) { result = "zero"; }
		System.out.println (result);
	}
}

class Num2Words {
	private static final String[] tensNames = {
	 "",
	 "ten",
	 "twenty",
	 "thirty",
	 "forty",
	 "fifty",
	 "sixty",
	 "seventy",
	 "eighty",
	 "ninety"
	};

	private static final String[] numNames = {
	 "",
	 "one",
	 "two",
	 "three",
	 "four",
	 "five",
	 "six",
	 "seven",
	 "eight",
	 "nine",
	 "ten",
	 "eleven",
	 "twelve",
	 "thirteen",
	 "fourteen",
	 "fifteen",
	 "sixteen",
	 "seventeen",
	 "eighteen",
	 "nineteen"
	};

	int n;
	public static String conv (int n) {
		if (n == 0) {
			return "";
		} else if (n < 20) {
			return numNames[n];
		} else if (n < 100) {
			return tensNames [n/10] + ((n % 10 != 0) ? " " : "") + numNames[n % 10];
		} else if (n < 1000) {
			return numNames [n/100] + " hundred" + ((n % 100 != 0) ? " " : "") + conv (n % 100);
		} else if (n < 10000) {
			return conv (n/1000) + " thousand" + ((n % 1000 != 0) ? " " : "") + conv (n % 1000);
		}
		return "";
	}
}

class PigLatinAPP {
	public PigLatinAPP () {
		MyLib.greeting ("to the Pig Latin Translator.");
	}

	public void translate () {
		String ask = "Enter a line to be translated to Pig Latin:\n";
		String s = MyLib.askInputStr (ask);
		MyLib.println (s);
		PigLatin item = new PigLatin (s.trim());
		String result = item.sentenceTranslator ();
		MyLib.println (result);
	}
}

class PigLatin {
	String si = "";
	String [] words;

	public PigLatin (String s) {
		this.si = s.trim();
		wordBuild(s);
	}

	public String sentenceTranslator() {
		String result = "";
		for (String value : words) {
			result += wordTranslator (value) + " ";
		}
		return result.trim();
	}

	public String [] wordBuild ( String s ) {
		words = s.split(" ");
		int index = 0;
		for (String value : words) { 
			MyLib.println (words[index]);
			words[index] = value.toLowerCase();
			MyLib.println (words[index]);
			index++;
		}
		return words;
	}

	public String wordTranslator ( String w ) {
		String newWord = w;
		int iFirstVowel = indexOfFirstVowel (w);

		switch (iFirstVowel) {
			case 0 :
				newWord = w + "way";
				break;
			default :
				newWord = w.substring (iFirstVowel) + w.substring (0, iFirstVowel) + "ay";
				break;
		}
		return newWord;
	}

	public static boolean hasSpecialCase ( String word ) {
		return (word == null || word.trim().isEmpty()) ? false : word.matches("[^A-Za-z0-9]");
	}

	public static boolean hasNumber ( String word ) {
		int i;
		for(i=0; i<word.length();i++){  
			switch(word.charAt(i)){
				case '0': case '1': case '2': case '3': case '4': 
				case '5': case '6': case '7': case '8': case '9': 
					return true;
			}
		}
		return false;
	}

	public static int indexOfFirstVowel ( String word ) {
		int i;
		for(i=0; i<word.length();i++){  
			switch(word.charAt(i)){
				case 'a': case 'e': case 'i': case 'o': case 'u': 
					return i;
				case 'y': 
					if (i == 0) continue;
					else return i;
			}
		}
		return -1;
	}

	public int indexOfFirstVowel2 (String word) {
		final String vowels = "aeiouy";
		int index = 0;
		for ( ; index < word.length(); index++) {
			if (vowels.contains (String.valueOf (word.charAt(index)))) {
				return index;
			}
		}
		return -1;
	}
	
}

class Circle {
	static int count = 0;
	double radius;

	public Circle (double radius) {
		this.radius = radius;
		count++;
	}

	public double getCircumference() {
		return 2 * Math.PI * radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public static int getObjectCount() {
		return count;
	}

}

class DiceRollerApp {
	static int count = 0;
	PairOfDice item = new PairOfDice();

	public void roll() {
		count++;
		System.out.println ("Roll " + count + ":");
		item.roll();
		msg();
	}

	public void msg() {
		switch (item.getValue1())
		{
			case 1:
				break;
			case 6:
				break;
			case 2:
			case 3:
			case 4:
			case 5:
			default:
				break;
		}
		if (item.getValue2() == 1 && item.getValue1() == 1) System.out.println ("Snake eyes!");
		if (item.getValue2() == 6 && item.getValue1() == 6) System.out.println ("Box cars!");
		if (item.getSum() == 7) {
			System.out.println ("Craps!");
		}
	}
} 

class PairOfDice {
	Die d1 = new Die();
	Die d2 = new Die();
	int n1 = 1;
	int n2 = 1;

	public PairOfDice() {
	}

	public PairOfDice(int sides) {
		d1.sides = sides;
		d2.sides = sides;
	}

	public void roll() {
		d1.roll();
		n1 = d1.getValue();
		d2.roll();
		n2 = d2.getValue();
		MyLib.display (n1);
		MyLib.displayLn ();
		MyLib.display (n2);
		MyLib.displayLn ();
	}

	public int getValue1() {
		return n1;
	}

	public int getValue2() {
		return n2;
	}

	public int getSum() {
		return n1 + n2;
	}
}

class Die {
	static int num = 1;
	int sides = 6;

	public Die () {
	}
	public Die (int sides) {
		this.sides = sides;
	}
	public Die (int number, int sides) {
		if (number > 1) num = number;
		this.sides = sides;
	}

	public void roll () {
		int value = (int) (Math.random() * sides);
		num += value;
		num %= sides;
		num++;
	}

	public int getValue () {
		return num;
	}

}
