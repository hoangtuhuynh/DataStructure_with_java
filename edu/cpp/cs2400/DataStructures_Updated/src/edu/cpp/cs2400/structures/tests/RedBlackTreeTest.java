/**
 * 
 */
package edu.cpp.cs2400.structures.tests;

import edu.cpp.cs2400.structures.trees.BinarySearchTree;
import edu.cpp.cs2400.structures.trees.RedBlackTree;

/**
 * @author autologin
 *
 */
public class RedBlackTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree<Integer> rbt = new RedBlackTree<Integer>();
		System.out.println("Adding 9, 7, 11!!");
		rbt.add(9);
		rbt.add(7);
		rbt.add(11);
		
		rbt.add(6);
		rbt.add(22);
		rbt.add(33);
		
		rbt.add(1);
		rbt.add(2);
		rbt.add(3);
		
		((RedBlackTree<Integer>) rbt).printTree();
		System.out.println("Size: "+ rbt.size());
		//System.out.println("done!");
		System.out.println("Adding 22 and Remove 9: ");
		rbt.add(22);
		rbt.remove(9);
		((RedBlackTree<Integer>) rbt).printTree();
		System.out.println("Size:" + rbt.size());
		
		System.out.println("Is 22 in the red black tree? " + rbt.find(22));
	}

}
