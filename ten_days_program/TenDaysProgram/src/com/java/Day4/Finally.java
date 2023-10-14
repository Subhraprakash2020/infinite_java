package com.java.Day4;

public class Finally {
	// declaring final variable
	final int age = 18;

	void display() {

		// reassigning value to age variable
		// gives compile time error
		age = 55;
	}

	public static void main(String[] args) {

		Finally obj = new Finally();
		// gives compile time error
		obj.display();
	}
}
