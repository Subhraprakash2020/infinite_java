package com.java.Day1;

import java.util.Scanner;

//Take a class as student
class Student {
	//Declaration of variable
	int rollno;
	String name;
	
   //Create a constructor
	public Student(int rollno, String name) {
		//access the current variable through this keyword
		this.rollno = rollno;
		this.name = name;
	}

	//Create antoher mathod for display
	void display() {
		System.out.println(rollno + " " + name);
	}

}

// main method
public class ThisKeyWord {
	public static void main(String[] args) {
		// Take input through scanner
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter rollno");;
		int roll = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		Student s1 = new Student(roll, name);
		s1.display();
		//Static declaration
		
//		//Object crateing name s1
//		Student s1 = new Student(111,"zzzzzz");
//		//call the method display
//		s1.display();
	}
}
