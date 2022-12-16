/**
 * 
 */
package edu.cpp.cs2400.structures.hashing;

/**
 * @author apoloimagod
 *
 */
public class StringKeyAdditiveHashTable<V> extends ParameterizedHashTable<String, V> {

	public StringKeyAdditiveHashTable() {
		super(new StringAdditiveHasher());
	}

}
