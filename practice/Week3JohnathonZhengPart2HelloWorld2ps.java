import java.util.Scanner; //fix syntax

public class Week3JohnathonZhengPart2HelloWorld2ps {

public static void main (String args[]) {
	//Declare and initialize variables 
	int height = 0; //fix syntax
	int feet = 0;
	int inches = 0;

	//prompt for height
	System.out.println("Enter your height in inches: "); //fix syntax
	Scanner scanIn = new Scanner(System.in);
	height = scanIn.nextInt(); //fix syntax
	
	//calculate height in feet and inches
	feet = height / 12; //fix syntax
	inches = height % 12;

	//print out height in feet and inches 
	System.out.println("You are " + feet + " feet and " + inches + " inches"); //fix syntax
	}
}