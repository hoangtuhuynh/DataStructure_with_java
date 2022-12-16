/**
 * This file pedagogical material for the course
 * CS 2400: Data Structures and Algorithms II
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 * 
 * Copyright (c) 2022 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs2400.structures.hashing;

/**
 * @author Edwin Rodr&iacute;guez
 * 
 */
public interface HashTable<K extends Comparable<K>, V> {

	public void add(K key, V value);

	public V remove(K key);

	public V lookup(K key);

	public V[] getSortedList(V[] list);

	public void printReport();



}
