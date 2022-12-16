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
 * This is the API declaration of a simple List.
 * 
 * @author Edwin Rodr&iacute;guez
 *
 */
public interface List<V> {
	
	/**
	 * This method adds an element to the list. If {@code elem} is
	 * {@code null} then the list is unchanged.
	 * 
	 * @param elem This is the element to be added.
	 * @return {@code true} if element is succesfully added. {@code false} otherwise.
	 * 
	 * @pre: {@code elem} is not {@code null}.
	 * 
	 * @post: <Here goes the post-condition>
	 */
	boolean add(V elem);
	
	/**
	 * Removes the first element of this list.
	 * 
	 * @return The removed element. {code null} if the list is empty.
	 */
	V remove();
	
	/**
	 * Returns the size of this list.
	 * 
	 * @return The size of this list.
	 */
	int size();
	
	/**
	 * Returns the element at position {@code i}. The element
	 * remains in the list.
	 * 
	 * @param pos The position of the element to be returned.
	 * @return The element at position {@code i}.
	 */
	V getElem(int i);
	
	/**
	 * Removes the last element of this list.
	 * 
	 * @return The removed element. {code null} if the list is empty.
	 */
	V removeLast();
	
	/**
	 * Removes the element at position {@code i}.
	 * 
	 * @param i The position of the element to be removed.
	 * @return The element at position {@code i}.
	 */
	V removeAt(int i);
	
	/**
	 * Check whether the list is empty.
	 * 
	 * @return {code true} if the list is empty. {@code false} otherwise.
	 */
	boolean isEmpty();

}
