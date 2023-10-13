package com.java.Day3;

//Abstraction class having constructor data member and methods
abstract class Bike {
	Bike() {
		System.out.println("bike is created");
	}

	abstract void run();

	void changeGear() {
		System.out.println("gear changed");
	}
}

// Creating a Child class which inherits Abstract class
class Honda extends Bike {
	void run() {
		System.out.println("running safely..");
	}
}

public class Abstraction2 {
	public static void main(String args[]) {
		Bike obj = new Honda();
		obj.run();
		obj.changeGear();
	}
}
