package com.java.Day1;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListA {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		//Adding object in arraylist
		list.add("Ravi");  
		list.add("Vijay");  
		list.add("Ravi");  
		list.add("Ajay");  
		
		//Remove from the list
		list.remove("Ajay");
		
		//Traversing list through iterator
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
