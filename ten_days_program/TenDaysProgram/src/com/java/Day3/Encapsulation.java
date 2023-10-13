package com.java.Day3;

//Crate a class As Student and define two variable
class Student {
	private String name;
	private int age;

	 //Creating getter and setter method
	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void setAge(int newAge) {
		if (newAge > 0) {
			age = newAge;
		}
	}

	public int getAge() {
		return age;
	}
}

public class Encapsulation {
	public static void main(String[] args) {
		//Creating a object
		Student student = new Student();
		student.setName("John");
		student.setAge(20);

		System.out.println("Name: " + student.getName());
		System.out.println("Age: " + student.getAge());
	}
}
