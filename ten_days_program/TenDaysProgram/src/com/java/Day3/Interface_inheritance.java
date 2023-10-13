package com.java.Day3;

interface Printable1 {
	void print();
}

interface Showable1 extends Printable1 {
	void show();
}

public class Interface_inheritance implements Showable {

	@Override
	public void show() {
		System.out.println("WelCOme");
	}
	public static void main(String[] args) {
		Interface_inheritance obj = new Interface_inheritance();
		obj.show();
	}

}
