/**
 * 
 */
package edu.cpp.cs2400.structures.tests;

import java.util.Arrays;
import java.util.Random;

import edu.cpp.cs2400.structures.lists.BoundedArrayList;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public class BoundedArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testAdd();
		System.out.println("\n");
		testAddRem();
	}
	
	private static void testAdd() {
		BoundedArrayList<Integer> l = new BoundedArrayList<Integer>(10);
		Random r = new Random();
		
		for (int i = 0; i < 10; ++i) {
			l.add(r.nextInt(100));
		}
		
		System.out.println(l.toString());
	}
	
	private static void testAddRem() {
		BoundedArrayList<Integer> l = new BoundedArrayList<Integer>(10);
		Random r = new Random();
		
		int numToAdd = r.nextInt(10) + 1;
		
		for (int i = 0; i < numToAdd; ++i) {
			l.add(r.nextInt(100));
		}
		
		String orig = "Original List: " + l.toString();
		
		int numToRem = r.nextInt(numToAdd) + 1;
		Integer[] elemRem = new Integer[numToRem];
		
		for (int i = 0; i < numToRem; ++i) {
			elemRem[i] = l.remove();
		}
		
		String output = orig + "\n" + l.toString() +
				"\nElements Removed: " + Arrays.toString(elemRem);
		System.out.println(output);
	}

}
