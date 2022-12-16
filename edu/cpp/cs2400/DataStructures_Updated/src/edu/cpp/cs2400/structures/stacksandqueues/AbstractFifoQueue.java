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
 * This is the interface for an abstract queue. This
 * structure obeys a FIFO policy: elements leave the
 * strucuture in the order they arrive.
 * 
 * @author Edwin Rodr&iacute;guez
 *
 */
public interface AbstractFifoQueue<V> {
	
	/**
	 * Inserts the element {@code elem} at the back
	 * of the queue.
	 * 
	 * @param elem The argument element to be inserted
	 *        in the queue.
	 */
	void enqueue(V elem);
	
	/**
	 * Returns and removes the element at the front of
	 * the queue. Returns {@code null} if the queue is
	 * empty.
	 * 
	 * @return The element at the front of the queue.
	 */
	V dequeue();
	
	/**
	 * Returns the element at the front of the queue
	 * without removing it. Returns {@code null} if
	 * the queue is empty.
	 * 
	 * @return The element at the front of the queue.
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
	 * @return The size of the queue.
	 */
	int size();
}
