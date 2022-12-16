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
 * A simple Linked List.
 * 
 * @author Hoang Tu Huynh
 *
 */
public class SimpleLinkedList<V> implements List<V> {

	
	
	Node head;
	public int count;
	
	@Override
	public boolean add(V elem) {
		// TODO Auto-generated method stub
		if(head == null) {
			head = new Node(elem);
		}
		else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next  = new Node(elem);
		}
		++count;
		return true;
	}

	@Override
	public V remove() {
		// TODO Auto-generated method stub
		V result = null;
		if(head != null) {
			result = head.elem;
			if(head.next != null) {
				head = head.next;
			}
			--count;
		}
		return result;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public V getElem(int i) {
		// TODO Auto-generated method stub
		V result = null;
		Node current = head;
		for( int value = 1; value <i; value++) {
			current = current.next;
		}
		result = current.elem;
		return result;
	}

	
	@Override
	public V removeLast() {
		// TODO Auto-generated method stub
		V result;
		if(head.next == null) {
			result = head.elem;
			head = null;
		}
		else {
			Node current = head;
			while(current.next.next != null) {
				current = current.next;
			}
			result = current.next.elem;
			current.next = null;
			//current = current.next;
			//current.elem = null;
			
		}
		--count;
		return result;
	}

	@Override
	public V removeAt(int i) {
		// TODO Auto-generated method stub
		V result;
		Node previous  = head;
	
		for (int value = 1; value < i - 1; i++)
			previous = previous.next;
		
		Node current = previous.next;
		previous.next = current.next;
		result = current.elem;
		current.next = null;
		--count;
		return result;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (count==0);
	}
	public void printList(SimpleLinkedList<V> list)
    {
        Node currNode = list.head;
 
        System.out.print("LinkedList: ");
 
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.elem + " ");
 
            // Go to next node
            currNode = currNode.next;
        }
 
        System.out.println();
    }
	public class Node{
		Node next;
		V elem;
		public Node(V elem){
			  this.elem = elem;
		}
	}

}


