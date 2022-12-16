/**
 * This file pedagogical material for the course
 * CS 2400: Data Structures and Algorithms II
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 * 
 * Copyright (c) 2022 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs2400.structures.stacksandqueues;

/**
 * This is the main interface for a heap data strucuture. Elements
 * stored in the heap must implement the {@link Comparable} interface,
 * i.e., elements must be subjected to a total order. The implementation
 * of this interface must allow the heap to be configured as either a max-heap or a
 * min-heap through the use of the {@link Heap#setMode(MODE)} method.
 * 
 * @author Edwin Rodr&iacute;guez
 * 
 */
public interface Heap<V extends Comparable<V>> {
	
	/**
	 * These are the possible values for the configuration of the heap:
	 * MAX for a max-heap, and MIN for a min-heap.
	 * 
	 * @author Edwin Rodr&iacute;guez
	 *
	 */
	public static enum MODE {MAX, MIN};

	/**
	 * Add an element to the heap. This method always succeeds.
	 * 
	 * @param value The value to be added to this heap.
	 */
	public void add(V value);

	/**
	 * Returns the array version of this heap. This is NOT necessarily the
	 * same as the internal array representation of this heap (if implemented
	 * as an array) as the internal array may be larger than needed. The elements
	 * should be arranged so that they represent a heap in the classical
	 * array-heap arrangement.
	 * 
	 * @return An array-heap version of this heap.
	 */
	public V[] toArray();

	/**
	 * Removes an element from this heap. The element removed is the element
	 * at the top of the heap. after removal, the heap invariant must restored
	 * before this method returns.
	 * 
	 * @return The element removed from the heap.
	 */
	public V remove();
	
	/**
	 * Takes an array of elements and populates this heap with them. If this heap
	 * was non-empty, the previous heap is lost. The elements in the array must not
	 * necessarily be arranged in the classical array-heap form.
	 * 
	 * @param array The elements used to construct this heap.
	 */
	public void fromArray(V[] array);

	/**
	 * Returns a sorted array with the elements in this heap. The elements should
	 * be sorted using heap-sort.
	 * 
	 * @return A sorted array with the elements of this heap.
	 */
	public V[] getSortedContents();
	
	/**
	 * Returns the mode for this heap: MAX if this is a max-heap, or
	 * MIN if this is a min-heap.
	 * 
	 * @return The mode for this heap.
	 */
	public MODE getMode();
	
	/**
	 * Sets the mode of this heap to a max heap of the argument is
	 * MAX, or a min-heap if the argument is MIN. This should also allow
	 * changing the heap from max-heap to a min-heap, and viceversa.
	 * 
	 * @param mode The new mode for this heap.
	 */
	public void setMode(MODE mode);

}
