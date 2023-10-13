package com.java.Day1;

import java.util.*;

public class ListA {
	public static void main(String[] args) {
		//Create a list using List interface
		//List<String> means only string type is assigned to this list
		List<String> list = new ArrayList<String>();
		//Adding element in list array through add keyword
		list.add("bus");
		list.add("car");
		
		//Set the element in list
		list.set(1, "truck");
		//Remove an element using index
		list.remove(1);
		
		
		//Display all the element from list using foreach loop
		for (String string : list) {
			System.out.println(string);
		}
		
		// Display one element using index value
		System.out.println(list.get(1));
		
		// Sorting the list using sort keyword
		Collections.sort(list);
		
		
	}
}
