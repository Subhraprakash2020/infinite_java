package com.java.Day3;

//Create a class Shape
abstract class Shape {
	abstract void draw();
}

// Rectange class inherit from shpe
class Rectangle extends Shape {
	
	void draw() {
		System.out.println("drawing rectangle");
	}
}

//Circle class inherit from shape
class Circle1 extends Shape {
	void draw() {
		System.out.println("drawing circle");
	}
}

class Abstraction1{
	public static void main(String args[]){  
		Shape s=new Circle1();//In a real scenario, object is provided through method, e.g., getShape() method  
		s.draw();  
		}  
}