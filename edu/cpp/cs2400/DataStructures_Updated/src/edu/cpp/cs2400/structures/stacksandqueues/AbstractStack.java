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
 * This is the interface for an abstract stack. This structure obeys a LIFO
 * policy: elements leave the structure in a last-in-first-out fashion, i.e.,
 * the next element to leave was the last element added.
 * 
 * @author Edwin Rodr&iacute;guez
 *
 */
public interface AbstractStack<V> {

	/**
	 * Inserts an element at the top of the stack.
	 * 
	 * @param elem The element to be added.
	 */
	void push(V elem);

	/**
	 * Returns the element at the top of the stack. Returns {@code null} if the
	 * stack is empty.
	 * 
	 * @return the element at the top of the stack.
	 */
	V pop();

	/**
	 * Returns the element at the top of the stack without removing it. Returns
	 * {@code null} if the stack is empty.
	 * 
	 * @return The element at the top of the stack.
	 */
	V peek();

	/**
	 * Check whether the stack is empty.
	 * 
	 * @return {@code true} if the stack is empty. {@code false} otherwise.
	 */
	boolean isEmpty();

	/**
	 * Returns the size of the queue.
	 * 
	 * @return The size of the queue.
	 */
	int size();
}
