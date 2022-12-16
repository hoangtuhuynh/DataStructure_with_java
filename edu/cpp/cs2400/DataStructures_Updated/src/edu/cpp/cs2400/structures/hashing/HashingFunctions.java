/**
 * This file pedagogical material for the course
 * CS 2400: Data Structures and Algorithms II
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 * 
 * Copyright (c) 2022 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs2400.structures.hashing;

import java.util.HashMap;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public class HashingFunctions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] names = {"Joseph", "Ian", "Bum", "Brian", "Nicholas",
				"Allan", "Salvador", "Michael", "Joshua", "Alejandro",
				"Emily", "Huy", "Jeffrey", "Jacob", "MacIntosh", "Maria",
				"Harrison", "Ngoan", "Toan", "David", "Ankur", "Perales",
				"Jeremiah", "Alexander", "Luis", "Casey", "Saunders", "Scianni",
				"Alec", "Eric", "Raymond", "Princess", "Alvin", "Cody", "Derek"};
		
		int[] bucketsHit = new int[35];
		
		for(String name : names) {
			int bucket = oneAtATimeHashing(name.toCharArray(), bucketsHit.length);
			++bucketsHit[bucket];
		}
		
		int numOfHits = 0;
		int maxCollisions = 0;
		int numOfCollisions = 0;
		int numOfChains = 0;
		
		for(int hit : bucketsHit) {
			if(hit > 0) {
				++numOfHits;
				if (hit > maxCollisions) {
					maxCollisions = hit;
				}
				
				if(hit > 1) {
					numOfCollisions += hit - 1;
					++numOfChains;
				}
			}
		}
		
		System.out.println("Number of buckets hit: " + numOfHits +
				"\nMaximum number of collisions: " + maxCollisions +
				"\nNumber of Collisions: " + numOfCollisions +
				"\nNumber of chains: " + numOfChains +
				"\nLoad factor: " + (((float)numOfHits)/((float)bucketsHit.length)));
	}
	
	public static int additiveHashing(char[] key, int tableSize) {
		int hash = 0;
		
		for(char c : key) {
			hash += c;
		}
		
		return hash % tableSize;
	}
	
	public static int xorHashing(char[] key, int tableSize) {
		int hash = 0;
		
		for (char c : key) {
			hash ^= c;
		}
		
		return hash % tableSize;
	}
	
	public static int xorShiftHashing(char[] key, int tableSize) {
		int hash = 0;
		
		for (char c : key) {
			hash += (c << 3) ^ (c >> 5) ^ hash;
		}
		
		hash = Math.abs(hash);
		
		
		return  hash % tableSize;
	}
	
	public static int oneAtATimeHashing(char[] key, int tableSize) {
		int hash = 0;
		
		for (char c : key) {
			hash += c;
			hash += (hash << 10);
			hash ^= (hash >> 6);
		}
		
		hash += (hash << 3);
		hash ^= (hash >> 11);
		hash += (hash << 5);
		
		hash = Math.abs(hash);
		
		return hash % tableSize;
	}
	
}
