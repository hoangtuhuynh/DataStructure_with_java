/**
 * This file pedagogical material for the course
 * CS 2400: Data Structures and Algorithms II
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 * 
 * Copyright (c) 2022 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs2400.structures.stacksandqueues;

import java.util.Arrays;

import edu.cpp.cs2400.structures.stacksandqueues.Heap.MODE;

/**
 * @author Edwin Rodr&iacute;guez
 * 
 */
public class ArrayHeap<V extends Comparable<V>> implements Heap<V> {

	/**
	 * We set the heap to have an initial size of 100.
	 */
	private int INITIAL_SIZE = 100;

	/**
	 * This is the mode of this heap. MAX for a max-heap, and MIN
	 * for a min-heap.
	 */
	private MODE mode;

	/**
	 * This is array representation of the heap.
	 */
	private Object[] theHeap;

	/**
	 * The number of elements in this heap.
	 */
	private int elemCount = 0;

	/**
	 * The index of the last element in the heap. Used to keep track
	 * of the end of the heap inside the array.
	 */
	private int lastIndex = 0;

	public ArrayHeap() {
		mode = Heap.MODE.MAX;
		theHeap = new Object[INITIAL_SIZE];
	}

	@Override
	public void add(V value) {
		ensureCapacity();

		if (elemCount++ > 0) {
			++lastIndex;
		}

		theHeap[lastIndex] = value;
		siftUp(lastIndex);
	}

	/**
	 * The sift-up function of the heap. Used to move elements up
	 * the heap tree, to restore the heap invariant when new elements
	 * are added.
	 * 
	 * @param index The index of the element to be sifted up.
	 */
	private void siftUp(int index) {
		assert (index >= 0 && index <= (lastIndex));
		
		// TODO: Implement me!
	}

	/**
	 * Used to ensure there is enough space in the array. Whenever
	 * an element is to be added, this method is called to check if there
	 * is enough space, and if there isn't a new array twice as large is
	 * allocated, and the elements are copied over to the new array, which
	 * becomes the array representation of the heap.
	 */
	private void ensureCapacity() {
		// TODO: Implement me!
	}

	@Override
	@SuppressWarnings("unchecked")
	public V[] toArray() {
		V[] result = null;
		
		if (elemCount > 0) {
			result = (V[]) java.lang.reflect.Array.newInstance(
					theHeap[0].getClass(), elemCount);

			System.arraycopy(theHeap, 0, result, 0, elemCount);

			return result;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove() {
		// TODO: Implement me!
		
		return null;
	}

	@Override
	public void fromArray(V[] array) {
		int newCapacity = computeCapacity(array.length);
		theHeap = Arrays.copyOf(array, newCapacity);
		elemCount = array.length;
		lastIndex = elemCount > 1 ? elemCount - 1 : 0;
		heapify();
	}

	/**
	 * This method turns an array into a classical array-heap.
	 */
	private void heapify() {
		if (elemCount > 1) {
			for (int i = (lastIndex - 1) / 2; i >= 0; --i) {
				siftDown(i);
			}
		}
	}

	/**
	 * This is a helper method used to allocate enough space
	 * to store {@code neededCapacity} elements in the heap.
	 * 
	 * @param neededCapacity The least amount of buckets needed in the array
	 * @return the actual amounts of buckets that will be allocated (>=
	 *         {@code neededCapacity}).
	 */
	private int computeCapacity(int neededCapacity) {
		int currentCapacity = theHeap.length;

		while (neededCapacity > currentCapacity) {
			currentCapacity *= 2;
		}

		return currentCapacity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V[] getSortedContents() {
		// TODO: Implement me!
		
		return null;
	}


	@Override
	public Heap.MODE getMode() {
		return mode;
	}

	@Override
	public void setMode(Heap.MODE mode) {
		this.mode = mode;
		heapify();
	}

	/**
	 * The sift-down function of the heap. Used to sift elements down
	 * the heap when an element is removed.
	 * 
	 * @param index The index of the element to be sifted down.
	 */
	private void siftDown(int index) {
		assert (index >= 0 && index <= (lastIndex));

		if (index <= ((lastIndex - 1) / 2)) {
			int ch1Index;
			int ch2Index;
			int swapIndex = 0;
			boolean swapped;

			do {
				swapped = false;
				ch1Index = 2 * index + 1;

				if (ch1Index <= lastIndex) {
					ch2Index = ch1Index + 1;

					swapIndex = ch2Index <= lastIndex
							&& compareValues(ch2Index, ch1Index) ? ch2Index
							: ch1Index;
				}

				if (compareValues(swapIndex, index)) {
					swapValues(swapIndex, index);
					index = swapIndex;
					swapped = true;
				}
			} while (swapped);
		}
	}

	/**
	 * A simple swapping function for the heap array.
	 * 
	 * @param index1 First index to be swapped.
	 * @param index2 Second index to be swapped.
	 */
	private void swapValues(int index1, int index2) {
		Object value = theHeap[index1];
		theHeap[index1] = theHeap[index2];
		theHeap[index2] = value;
	}

	/**
	 * The compare function used by this heap for the elements stored.
	 * 
	 * @param index1 The index of the first element to be compared.
	 * @param index2 The index of the second element to be compared.
	 * @return If this is a max-heap (min-heap) then {@code true} if element at
	 * 		   {@code index1} is greater than (less than) element at {@code index2}.
	 * 		   {@false } otherwise.
	 */
	private boolean compareValues(int index1, int index2) {
		if (mode == Heap.MODE.MAX) {
			return ((V) theHeap[index1]).compareTo((V) theHeap[index2]) > 0;
		} else {
			return ((V) theHeap[index1]).compareTo((V) theHeap[index2]) < 0;
		}
	}

}
