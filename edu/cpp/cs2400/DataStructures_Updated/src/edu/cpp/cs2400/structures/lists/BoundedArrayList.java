/**
 * This file pedagogical material for the course
 * CS 2400: Data Structures and Algorithms II
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 * 
 * Copyright (c) 2022 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs2400.structures.lists;

import java.util.Arrays;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public class BoundedArrayList<V> implements List<V> {
	
	/**
	 * This is the internal representation of the list.
	 */
	protected Object[] theList;
	
	/**
	 * The number of elements in the list.
	 * @initially {@code 0}.
	 */
	private int count = 0;
	
	/**
	 * Keeps track of the beginning of the list.
	 */
	private int first = 0;
	
	
	/**
	 * Keeps track of the end of the list.
	 */
	private int last = 0;
	
	

	public BoundedArrayList(int bound) {
		theList = new Object[bound];
	}

	/**
	 *
	 */
	@Override
	public boolean add(V elem) {
		assert (elem != null);
		
		boolean result = false;
		
		if(count < theList.length) {
			last = count == 0 ? last : (last + 1) % theList.length;
			theList[last] = elem;
			++count;
			result = true;
		}
		
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove() {
		V result = null;
		
		if (count > 0) {
			result = (V) theList[first];
			first = count == 1 ? first : (first + 1) % theList.length;
			--count;
		}
		
		return result;
	}

	@Override
	public int size() {
		// TODO Implement me!
		return 0;
	}

	@Override
	public V getElem(int pos) {
		// TODO Implement me!
		return null;
	}

	@Override
	public V removeLast() {
		// TODO Implement me!
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Implement me!
		return false;
	}

	@Override
	public String toString() {
		return Arrays.toString(theList) +
				"\nfirst: " + first +
				"\nlast: " + last +
				"\ncount: " + count;
	}

	@Override
	public V removeAt(int n) {
		// TODO Implement me!
		return null;
	}

}
