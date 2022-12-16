/**
 * This file pedagogical material for the course
 * CS 2400: Data Structures and Algorithms II
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 * 
 * Copyright (c) 2022 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs2400.structures.lists;

/**
 * This is an unbounded version of the list. It extends
 * {@link BoundedArrayList} and overrides the method
 * {@link BoundedArrayList#add(Object)} to allow for the array
 * to grow if more space is needed, making the list effectively
 * unbounded.
 * 
 * @author Edwin Rodr&iacute;guez
 *
 */
public class UnboundedArrayList<V> extends BoundedArrayList<V> {

	public UnboundedArrayList(int bound) {
		super(bound);
	}

	@Override
	public boolean add(V elem) {
		ensureCapacity();
		super.add(elem);
		
		return true;
	}

	/**
	 * This is a helper method that checks whether there is enough space
	 * to add a new element, and if there isn't, allocated a new array of
	 * size 2 times that of the internal list array, then copies over the
	 * elements into the new array, which is the made the new internal list
	 * array representation.
	 */
	private void ensureCapacity() {
		// TODO Implement me!
		
	}

}
