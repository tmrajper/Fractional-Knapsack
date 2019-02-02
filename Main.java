/**
 * 
 */
package edu.cpp.cs.cs331;

/**
 * @author tarikrajper
 *
 */

import java.util.Scanner;


public class Main {
	
	private static Scanner scan;
	//Gets Number of Objects from user
	private static int objects;
	//Matrix used to hold values of profit and weight
	private static int[][] input;
	//Gets Knapsack capacity from user
	private static int capacity;
	//Maximized profit derived from data given
	private static int maximizedProfit;
	//Used to check if current weight is over knapsack
	private static int current;
	//Used to calculate fractional knapsack
	private static int diff;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		capacity = 0;
		objects = 0;
		maximizedProfit = 0;
		current = 0;
		diff = 0;
		
		//Gets User's Knapsack Capacity
		getKnapsackCapacity();
		//Gets Number of Objects from user
		getNumberOfObjects();
		//Initializes matrix
		input = new int[2][objects];
		//Gets each objects weight input
		getWeightInput();
		//Gets each objects profit input
		getProfitInput();
		//Calculates max profit using Fractional knapsack
		fractionalKnapsack();
		//prints max profit
		printMaxProfit();
		
		
	}
	
	//Prints Maximized profit
	public static void printMaxProfit() {
		System.out.println("Maximum Profit considering Knapsack Capacity: " + maximizedProfit);
		scan.close();
	}
	
	//Calculates max profit
	public static void fractionalKnapsack() {
		
		//Loops through all objects
		for (int i = 0; i < objects; i++) {
			
			//Checks if current + value at i is less than capacity
			if (current + input[0][i] <= capacity) {
				//Adds current to value at i
				current += input[0][i];
				//Updates max profit
				maximizedProfit += input[1][i];
				//Prints Which objects are used
				System.out.println("Using Object: " + i);
			} else {
				//Calculates difference between capacity and currentCapacity
				diff = capacity - current;
				//Updates Max profit by fractional amount
				maximizedProfit += input[1][i] * ((double) diff / input[0][i]);
				//Prints object used
				System.out.println("Using Object: " + i);
				break;
			}
		}
		
	}
	
	//Gets Weights for each object
	public static void getWeightInput() {
		System.out.println("Enter Weight Values for Each Object: ");
		
		for (int i = 0; i < objects; i++) {
			input[0][i] = scan.nextInt();
		}
	}
	
	//Gets profit for each object
	public static void getProfitInput() {
		System.out.println("Enter Profit Values For Each Object: ");
		
		for (int i = 0; i < objects; i++) {
			input[1][i] = scan.nextInt();
		}
	}
	
	//Gets Knapsack Capacity
	public static void getKnapsackCapacity() {
		System.out.println("Enter Knapsack Capacity: ");
		capacity = scan.nextInt();
	}
	
	//Gets Number of Objects
	public static void getNumberOfObjects() {
		System.out.println("Enter Number Of Objects: ");
		objects = scan.nextInt();
	}
}
