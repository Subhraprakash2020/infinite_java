package com.java.Day2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NestedTry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
        	//Outer try block
            System.out.print("Enter the numerator: ");
            int numerator = sc.nextInt();

            System.out.print("Enter the denominator: ");
            int denominator = sc.nextInt();
            try {
            	//Inner try block
                double result = numerator / (double) denominator;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero is not allowed.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers for the numerator and denominator.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Close the scanner in the finally block to ensure proper cleanup
            sc.close();
        }
    }
}
