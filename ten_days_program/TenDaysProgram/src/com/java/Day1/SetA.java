package com.java.Day1;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetA {
	public static void main(String[] args) {
		//Create a set name data
		Set<String> data = new LinkedHashSet<>();
		
		// Adding element in set using add keyword
		data.add("JavaTpoint");   
         
        data.add("Example");   
        data.add("Set");
        
        //Remove element from set
        data.remove("set");
        
        //Remove all the data from the list
        data.removeAll(data);
        
        //Retains all the element from the given set
        data.retainAll(data);
        //Display the set
        System.out.println(data);
        
        //Calculate the size of the set
        System.out.println(data.size());
	}
}
