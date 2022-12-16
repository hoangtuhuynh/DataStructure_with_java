package edu.cpp.cs2400.structures.tests;

import java.util.Arrays;

import edu.cpp.cs2400.structures.hashing.SimpleHashTable;

public class SimpleHashTableTest {

	

	public static void main(String[] args) {
		SimpleHashTable<String, Integer> table = new SimpleHashTable<String, Integer>();
		table.add("Hoang", 1);
		table.add("Tu", 2);
		table.add("Huynh", 3);
		table.add("Josep", 3);
		table.add("Java", 5);
		table.add("Andrew", 7);
		table.add("Data", 5);
		
		table.printReport();
		
		System.out.println("Trying to find value of key \"Java\": " + table.lookup("Java"));
		System.out.println("Remove \"Java\" from the Hashtable:  ");
		table.remove("Java");
		table.printReport();
		
		System.out.println("Sorting value of key:"+ Arrays.toString(table.getSortedList()));
		
        
	}

}
