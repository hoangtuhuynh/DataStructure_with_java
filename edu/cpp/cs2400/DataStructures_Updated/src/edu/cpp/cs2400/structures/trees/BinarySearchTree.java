/**
 * This file pedagogical material for the course
 * CS 2400: Data Structures and Algorithms II
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 * 
 * Copyright (c) 2022 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs2400.structures.trees;

/**
 * This is the interface for a Binary Search Tree.
 * 
 * @author Edwin Rodr&iacute;guez
 *
 */
public interface BinarySearchTree<V extends Comparable<V>> {
	
	// TODO: Add documentation to every single method in this interface
	
	void add(V elem);
	
	void remove(V elem);
	
	boolean find(V elem);
	
	int size();
	
	String inOrderTraversal();

}
