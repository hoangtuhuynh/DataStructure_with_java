/**
 * 
 */
package edu.cpp.cs2400.structures.hashing;

import java.util.ArrayList;
import java.util.Arrays;



/**
 * @author apoloimagod
 * @param <K>
 *
 */
public abstract class ParameterizedHashTable<K extends Comparable<K>, V> implements HashTable<K, V> {
	
	private HashingFunction<K> hashFunction;
	
	private ArrayList<Entry>[] table;
	
	private int usedBuckets = 0;
	private int numElem = 0;
	
	public ParameterizedHashTable(HashingFunction<K> hashFunction) {
		this.hashFunction = hashFunction;
		table = new ArrayList[100];
	}

	@Override
	public void add(K key, V value) {
		int hash = hashFunction.hash(key);
		double loadFactor = ((double)usedBuckets) / table.length;
		double density = ((double)numElem) / table.length;
		
		if (loadFactor > .85 || density > .85) {
			resize();
		}
		
		if (table[hash] == null) {
			table[hash] = new ArrayList();
		}
		
		if (table[hash].isEmpty()) ++usedBuckets;
		
		table[hash].add(new Entry(key,value));
		++numElem;
	}

	private void resize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(K key) {
		if (key == null) return null;
		return null;
	}

	@Override
	public V lookup(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V[] getSortedList(V[] list) {
		V[] result = (V[])java.lang.reflect.
				Array.newInstance(list.getClass().getComponentType(), numElem);
		Entry[] entries = getEntries();
				
		for (int i = 0; i < numElem; ++i) {
			result[i] = entries[i].value;
		}
		
		return result;
	}


	private Entry[] getEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printReport() {
		// TODO Auto-generated method stub
		
	}
	
	private class Entry implements Comparable<Entry> {
		public Entry(K k, V v) {
			key = k;
			value= v;
		}
		
		protected K key;
		protected V value;
		
		@Override
		public int compareTo(Entry o) {
			// TODO Auto-generated method stub
			return this.key.compareTo(o.key);
		}
	}

}
