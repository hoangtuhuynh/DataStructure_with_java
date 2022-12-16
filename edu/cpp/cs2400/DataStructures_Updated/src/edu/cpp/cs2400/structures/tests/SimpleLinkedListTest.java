package edu.cpp.cs2400.structures.tests;

import edu.cpp.cs2400.structures.lists.SimpleLinkedList;

public class SimpleLinkedListTest {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		System.out.println("\tTest LinkedList\n Add 6 elements in the list:");
		list.add(3);
		list.add(7);
		list.add(22);
		list.add(5);
		list.add(14);
		list.add(9);
		list.printList(list);
		
		System.out.println("Remove the first element from the list:");
		list.remove();
		list.printList(list);
		
		System.out.println("Remove the last element from the list:");
		list.removeLast();
		list.printList(list);
		
		System.out.println("Get element at position 2: ");
		int value = list.getElem(2);
		System.out.println(value);
		
		System.out.println("Remove the element at position 2:");
		list.removeAt(2);
		list.printList(list);
		
		System.out.println("Is the list empty?");
		System.out.println(list.isEmpty());
	}

}
