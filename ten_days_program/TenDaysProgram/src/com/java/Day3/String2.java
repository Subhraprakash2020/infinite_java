package com.java.Day3;

import java.util.Scanner;

public class String2 {
	 public static void main(String[] args) {
	     
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter a Number : ");
		 String str = sc.next();
		 sc.close();
		 try {
//	here we are trying to convert the Str String into an integer a...
			int a = Integer.parseInt(str);
			System.out.println("a = "+a);
//	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.err.println("String Cannot be converted into   ");
		}
				 
	    }
}
