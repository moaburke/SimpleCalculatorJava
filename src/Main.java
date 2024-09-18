/**
 * Calculator Console Application
 * 
 * @author Moa Burke
 * 18 Sept 2024
 * 
 * This program allows users to perform basic arithmetic operations 
 * such as addition, subtraction, multiplication, and division.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//Create a Scanner object to read user input
		Scanner userInput = new Scanner(System.in);
		
		int choice = 0; //Variable to store users menu selection
		double num1 = 0;//Prepare variables to store the input number and initiate
		double num2 = 0;//Prepare variables to store the input number and initiate
		double result = 0; //Prepare variables to store the calculated result and initiate 
		
		boolean validInput = false; //Flag to control whether user input is valid
		
		//Continue looping until user choose to exit 
		while (true) {
			
			//Print menu selections to user
			System.out.println("CALCULATOR MENU");
			System.out.println("----------------");
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("5. Exit");

			
			//Repeat the loop until a valid integer between 1 and 5 is entered
			do {
				System.out.print("Enter your choice (1-5): ");
				//Check the input
				try {
					choice = userInput.nextInt(); //Process and read entry as an integer
					validInput = true;  
					
					if((choice < 1 || choice > 5)) {
						System.out.println("Invalid choice! Please input an integer between 1-5.");
						validInput = false; //Set flag to false
					}
					
			    } catch (InputMismatchException e) {
			        //Print error message if the read input was not an integer or if it was out of range
			        System.out.println("Invalid input! Please enter an integer.");
			        userInput.nextLine(); //Clear the invalid input
			        validInput = false; //Set flag to false
			    } catch (Exception e) {
			        //Print error message if convert a string with an incorrect format to a numeric value
			        System.out.println("An unexpected error occured: " + e.getMessage());
			        userInput.nextLine(); //Clear the buffer
			        validInput = false; //Set flag to false
			    } 
								
			} while (!validInput); 
				
			System.out.println(); //Empty line
			//If user input is 5 and want to exit program
			if (choice == 5) { 
				System.out.println("Goodbye!"); //Message to user
				break; //Exit the switch statement
			}		
		
			//Call method to get second number to use in calculation
			num1 = getValidNumber(userInput, "Enter first number: ");
			
			//Call method to get second number to use in calculation
			num2 = getValidNumber(userInput, "Enter second number: ");
			
					
			//Perform operators based on the user's choice
			switch(choice) {
				case 1:
					//If choice is 1, perform addition
					result = add(num1, num2);
					//System.out.printf("%f0.1 + %f = %f", num1, num2, result);
					System.out.println("Result: " + result);
					break; //Exit the switch after performing addition
				case 2:
					//If choice is 1, perform subtraction
					result = subtract(num1, num2);
					System.out.println("Result: " + result);
					break; //Exit the switch after performing subtraction
				case 3:
					//If choice is 1, perform multiplication
					result = multiply(num1, num2);
					System.out.println("Result: " + result);
					break; //Exit the switch after performing multiplication
				case 4:
					//If choice is 1, perform division
					result = divide(num1, num2);
					System.out.println("Result: " + result);
					break; //Exit the switch after performing division
				default:
					//If none of the cases match, print invalid choice
					System.out.println("Invalid choice!");
					break; //Exit the switch after handling invalid choice
				
			}
			
			System.out.println(); //Empty line
			choice = 0; //Reset user choice
		}
		
		userInput.close(); //Close the scanner
	}
	
	/**
	 * Prompts the user to enter a valid number and handles validation.
	 * The method repeatedly asks for input until a valid double is provided.
	 * 
	 * @param userInput Scanner object used to read input from user
	 * @param prompt A message displayed to the user to request input
	 * @return A valid double value entered by the user
	 */
	public static double getValidNumber(Scanner userInput, String prompt) {
		double num = 0; //Create and initiate given variable to store number from user
		boolean validInput = false; //Flag to control whether user input is valid
		
		//Repeat loop until a valid number is entered
		do {
			System.out.print(prompt); //Prompt user for input
			
			try {
				num = userInput.nextDouble(); //Process and read entry as double
				validInput = true; //Set flag to true
		    } catch (InputMismatchException e) {
		        //Print error message if the read input was not an integer or if it was out of range
		        System.out.println("Invalid input! Please enter a number.");
		        userInput.nextLine(); //Clear the invalid input
		        validInput = false; //Set flag to false
		    } catch (Exception e) {
		        //Print error message if convert a string with an incorrect format to a numeric value
		        System.out.println("An unexpected error occured: " + e.getMessage());
		        userInput.nextLine(); //Clear the buffer
		        validInput = false; //Set flag to false
		    }
		} while(!validInput);
		
		return num; //Return the valid number
	}
	
	/**
	 * This method takes two double values as input, adds them together, and returns the result.
	 * @param num1 the first number to add
	 * @param num2 the second number to add
	 * @return the sum of num1 and num2
	 */
	public static double add(double num1, double num2) {
		return num1 + num2; //Return the sum of num1 and num2
	}
	
	/**
	 * This method takes two double values as input, subtracts the second number from the first, and returns the result.
	 * 
	 * @param num1 the number to be subtracted from
	 * @param num2 the number to subtract
	 * @return the result of num1 and num2
	 */
	public static double subtract(double num1, double num2) {
		return num1 - num2; //Return the sum of num1 minus num2
	}

	/**
	 * This method takes two double values as input, multiplies them together, and returns the result.
	 * @param num1 the first number to multiply
	 * @param num2 the second number to multiply
	 * @return the product of num1 and num2
	 */
	public static double multiply(double num1, double num2) {
		return num1 * num2; //Return the product of num1 minus num2
	}
	
	/**
	 * This method performs a division operation, checking if the divisor (num2) is zero to prevent
	 * division by zero, which would result in an error. If num2 is zero, an error message if printed,
	 * and the method returns 0. Otherwise, it returns the result of the division of num1 bu num2.
	 * 
	 * @param num1 the dividend (the number to be divided)
	 * @param num2 the divisor (the number to divide by)
	 * @return the result of num1 divides by num2 if num2 is non-zero, otherwise returns 0
	 */
	public static double divide(double num1, double num2) {
		//Check if the divisor is zero to prevent division by zero
		if (num2 ==0) {
			System.out.println("Error: Cannot divide by zero"); //Print error message
			return 0; //Return 0 to indicate an error condition
		}
		//Return the result of num1 divided by num2
		return num1 / num2; 
	}
}
