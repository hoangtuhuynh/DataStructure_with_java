/**
 * This file pedagogical material for the course
 * CS 2400: Data Structures and Algorithms II
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 * 
 * Copyright (c) 2022 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs2400.structures.hashing;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author Edwin Rodr&iacute;guez
 * @param <K>
 *
 */
public class SimpleHashTable<K, V> implements HashTable<String, V> {

	
	@SuppressWarnings("hiding")
	class HashNode<K, V> {
		String key;
		V value;
		HashNode<K, V> next = null;

		public HashNode(String key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	ArrayList<HashNode<K, V>> bucket = new ArrayList<>();
	
	int numBuckets = 10;
	int size;
	public void addHash() {
		for (int i = 0; i < numBuckets; i++) {
		bucket.add(null);
		}
	}
	 
	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	public Object[] getSortedList() {
		// we have got total size elements
		Object result[] = new Object[size];
		int count = 0;

		for (int index = 0; index < numBuckets; index++) {
			HashNode<K, V> head = bucket.get(index);
			while (head != null) {
				result[count++] = head.value;
				head = head.next;
			}
		}
		Arrays.sort(result);

		return result;
	}

	@Override
	public void add(String key, V value) {
		//String a = key.toString();
		addHash();
		char[] b = key.toCharArray();
		int index = xorShiftHashing(b, numBuckets);
		HashNode<K, V> head = bucket.get(index);
		HashNode<K, V> toAdd = new HashNode<>(key, value);

		if (head == null) {
			bucket.set(index, toAdd);
			size++;
		} 
		else {
			while (head != null) {
				if (head.key.equals(key)) {
						head.value = value;
		// size++; No need to increase the size, as the key is
		// already present in the table
						break;
				}
				head = head.next;
			}
			if (head == null) {
				head = bucket.get(index);
				toAdd.next = head;
				bucket.set(index, toAdd);
				size++;
			}
		}
		// Resizing logic
		if ((1.0 * size) / numBuckets > 0.7) {
			// do something
			ArrayList<HashNode<K, V>> tmp = bucket;
			bucket = new ArrayList<>();
			numBuckets = 2 * numBuckets;
			for (int i = 0; i < numBuckets; i++) {
				bucket.add(null);
			}
			for (HashNode<K, V> headNode : tmp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
		
	}
	public int xorShiftHashing(char[] key, int numBuckets) {
		int hash = 0;

		for (char c : key) {
			hash += (c << 3) ^ (c >> 5) ^ hash;
		}
		hash = Math.abs(hash);

		return hash % numBuckets;
	}
	@Override
	public V remove(String key) {
		//String a = key.toString();
		char[] b = key.toCharArray();
		
		int index = xorShiftHashing(b, numBuckets);
		HashNode<K, V> head = bucket.get(index);
		if (head == null) {
			return null;
		}
		if (head.key.equals(key)) {
			V val = head.value;
			head = head.next;
			bucket.set(index, head);
			size--;
			return val;
		} 
		else {
			HashNode<K, V> prev = null;
			while (head != null) {

				if (head.key.equals(key)) {
					prev.next = head.next;
					size--;
					return head.value;
				}
				prev = head;	
				head = head.next;
			}
			size--;
			return null;
		}
	}

	@Override
	public V lookup(String key) {
		//String a = key.toString();
		char[] b = key.toCharArray();
		
		int index = xorShiftHashing(b, numBuckets);
		HashNode<K, V> head = bucket.get(index);
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	
	@Override
	public V[] getSortedList(V[] list) {
		Arrays.sort(list);
		return list;
	}
	@Override
	public void printReport() {
		int usedBuckets = 0;
		int longestBucket = 0;
		int totalBucketLen = 0;
		

		
		for (int index = 0; index < numBuckets; index++) {
			System.out.print("Index " + index + ": ");
			HashNode<K, V> head = bucket.get(index);
			int bucketLen = 0;

			if (head != null) {
				usedBuckets++;
			}
			while (head != null) {
				System.out.print(head.key + "(" + head.value + ")" + " => ");
				head = head.next;
				bucketLen++;
			}
			System.out.println();

			if (bucketLen > longestBucket) {
				longestBucket = bucketLen;
			}
			totalBucketLen += bucketLen;
		}
		System.out.println("Load factor: " + (1.0 * usedBuckets / numBuckets) + "\n" + "Longest Chain: " + longestBucket
		+ " collisions" + "\n" + "Density Factor: " + (1.0 * size / numBuckets) + "\n" + "Chaining Factor: "
		+ (1.0 * totalBucketLen / numBuckets));
	}
	
}
