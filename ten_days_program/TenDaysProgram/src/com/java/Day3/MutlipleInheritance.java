package com.java.Day3;

interface Printable {
	void print();
}

interface Showable {
	void show();
}

public class MutlipleInheritance implements Printable,Showable{

	@Override
	public void show() {
		System.out.println("Hello");
	}

	@Override
	public void print() {
		System.out.println("WelCome");
	}
	public static void main(String[] args) {
		MutlipleInheritance obj = new MutlipleInheritance();
		obj.print();  
		obj.show(); 
	}
	
	

}
