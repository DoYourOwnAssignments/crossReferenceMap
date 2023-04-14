import java.io.*;
import java.util.Scanner;

public class XRef {
	public static void main(String[] args) {
		printHeader();
		try {
		printFileContent(args);
		crossReference();
		} catch (Exception e) {
			System.out.println("An error occured");
		}
		printFooter();
	}

	public static void printHeader() {
		System.out.println("X R e f v 1");
		System.out.println("==========================================");
		System.out.println("Program created by DoYourOwnAssignments. 20-03-2021\n");
	}
	
	public static void printFileContent(String[] args) {
		try {
		String filename = args[0];
		String line;
		int counter = 1;

		Scanner fin = new Scanner(new File(filename));
		System.out.println("SOURCE FILE: " + filename);

		while (fin.hasNextLine()) {
			line = fin.nextLine();
			System.out.printf("%04d | %s %n", counter , line);
			counter++;
		}
		fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("Failed to open file " + args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Usage: java ReadTextFile <filename>");
		}
	}
	
	public static void crossReference() {
	}
	
	public static void printFooter() {
		System.out.println("\nXRef normally terminated.");
	}
}