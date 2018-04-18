package com.bladimirhernandez.taskManager;
import java.util.Scanner;

public class StudentHelper {
	public static String ReadInputString() {
		//declare a new scanner object
		Scanner input = new Scanner(System.in);
		
		//read in user input and store it
		String userInput = input.nextLine();
		
		//return 
		return userInput;
	}
}
