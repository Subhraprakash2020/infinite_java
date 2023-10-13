package com.java.Day3;

import java.util.Scanner;

public class String1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String : ");
		String str = sc.next();
        //Contains key word check wheather the value is availabe 
		//or not
		if (str.contains("Java")) {
			System.out.println("Contains Java...");
		} else if (str.equalsIgnoreCase("Pakistan")) {
			System.err.println("You are Restricted...");
		} else {
			System.out.println("Does not Conatains Java...");
		}
	}
}
