package com.java.Day1;

import java.util.*;

public class MapA {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Apple");
		map.put(2, "Mango");
		
		for(Map.Entry m:map.entrySet()) {
			System.out.println(m.getKey() + " "+m.getValue());
		}

	}
}
