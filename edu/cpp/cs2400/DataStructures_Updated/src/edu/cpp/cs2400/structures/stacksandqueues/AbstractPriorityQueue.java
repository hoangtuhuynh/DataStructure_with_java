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
 * @author apoloimagod
 *
 */
public interface AbstractPriorityQueue<V extends Comparable<V>> {
	
	/**
	 * Inserts the element {@code elem} in the queue. Elements are prioritized
	 * according to the total order imposed by {@link Comparable#compareTo(Object)},
	 * so that if {@code o1.compareTo(o2 > 0)} then {@code o1} has higher priority than
	 * {@code o2}.
	 * 
	 * @param elem The argument element to be inserted
	 *        in the queue.
	 */
	void enqueue(V elem);
	
	/**
	 * Returns and removes the element with the highest priority. Returns {@code null} if
	 * the queue is empty.
	 * 
	 * @return The element removed from the queue.
	 */
	V dequeue();
	
	/**
	 * Returns the element with the highest priority
	 * without removing it. Returns {@code null} if
	 * the queue is empty.
	 * 
	 * @return The element with the highest priority in the queue.
	 */
	V poll();
	
	/**
	 * Check whether the queue is empty.
	 * 
	 * @return {@code true} if the queue is empty. {@code false} otherwise.
	 */
	boolean isEmpty();
	
	/**
	 * Returns the size of the queue.
	 * 
	 * @return The number of elements in the queue.
	 */
	int size();

}
