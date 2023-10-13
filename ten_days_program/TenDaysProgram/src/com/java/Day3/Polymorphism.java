package com.java.Day3;

//Crate a class shpe1 and declar a method draw
class Shape1 {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

//Cirle extends shape1
class Circle extends Shape1 {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square extends Shape1 {
    @Override
    void draw() {
        System.out.println("Drawing a square");
    }
}	

public class Polymorphism {
	public static void main(String[] args) {
        Shape1 circle = new Circle();
        Shape1 square = new Square();

        circle.draw();  // Calls the draw method of Circle
        square.draw();  // Calls the draw method of Square
    }
}
