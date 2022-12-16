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
 * @author Edwin Rodr&iacute;guez
 *
 */
public class RedBlackTree<V extends Comparable<V>> implements BinarySearchTree<V> {

	public enum color {
		RED, BLACK
	};
	private  boolean RED = false;
	private  boolean BLACK = true;
	private Node root;
	private int count;

	@SuppressWarnings("unchecked")
	private Node sentLeaf = new Node((V) color.BLACK);

	@Override
	public void add(V elem) {
		Node node = root;
		  Node parent = null;

		 
		  while (node != null) {
		    parent = node;
		    if (node.elem.compareTo(elem)>0) {
		      node = node.lChild;
		    } 
		    else {
		    	node = node.rChild;
		    }
		  }

		  // Insert new node
		  Node newNode = new Node(elem);
		  newNode.color = RED;
		  if (parent == null) {
		    root = newNode;
		  } else if (parent.elem.compareTo(elem)>0) {
		    parent.lChild = newNode;
		  } else {
		    parent.rChild = newNode;
		  }
		  newNode.parent = parent;

		  fixTreeAdd(newNode);

		  ++count;
	}

	private void fixTreeAdd(RedBlackTree<V>.Node newNode) {
		// TODO Auto-generated method stub
		Node parent = newNode.parent;
		// Case 1: Parent is null, we've reached the root, the end of the recursion
		 if (parent == null) {
		   // node.color = BLACK;
		   return;
		 }
		// Parent is black --> nothing to do
		 if (parent.color == BLACK) {
		   return;
		 }
		 
		// From here on, parent is red
		 Node grandparent = parent.parent;
		// Case 2:
		 if (grandparent == null) {
			 parent.color = BLACK;
			 return;
		 }
		// Get the uncle (may be null/nil, in which case its color is BLACK)
		 Node uncle = findUncleNode(parent);

		 // Case 3: Uncle is red -> recolor parent, grandparent and uncle
		 if (uncle != null && uncle.color == RED) {
		   parent.color = BLACK;
		   grandparent.color = RED;
		   uncle.color = BLACK;

		  
		   fixTreeAdd(grandparent);
		 }
		// Parent is left child of grandparent
		 else if (parent == grandparent.lChild) {
		    // Case 4a: Uncle is black and node is left->right "inner child" of its grandparent
		   if (newNode == parent.rChild) {
		     rotateLeft(parent);

		    
		     parent = newNode;
		   }
		// Case 5a: Uncle is black and node is left->left "outer child" of its grandparent
		   rotateRight(grandparent);

		  
		   parent.color = BLACK;
		   grandparent.color = RED;
		 }

		 
		 else {
		   // Case 4b: Uncle is black and node is right->left "inner child" of its grandparent
		   if (newNode == parent.lChild) {
		     rotateRight(parent);
		     parent = newNode;
		   }

		   // Case 5b: Uncle is black and node is right->right "outer child" of its grandparent
		   rotateLeft(grandparent);

		   parent.color = BLACK;
		   grandparent.color = RED;
		  }
	
	}
	private Node findUncleNode(RedBlackTree<V>.Node parent) {
		  Node grandparent = parent.parent;
		  if (grandparent.lChild == parent) {
		    return grandparent.rChild;
		  } else if (grandparent.rChild == parent) {
		    return grandparent.lChild;
		  } else {
		    throw new IllegalStateException("Parent is not related to its grandparent");
		  }
	}
	private void rotateLeft(RedBlackTree<V>.Node node) {
		  Node parent = node.parent;
		  Node rightChild = node.rChild;

		  node.rChild = rightChild.lChild;
		  if (rightChild.lChild != null) {
		    rightChild.lChild.parent = node;
		  }

		  rightChild.lChild = node;
		  node.parent = rightChild;

		  ReplaceChild(parent, node, rightChild);
	}
	private void rotateRight(RedBlackTree<V>.Node node) {
		  Node parent = node.parent;
		  Node leftChild = node.lChild;

		  node.lChild = leftChild.rChild;
		  if (leftChild.rChild != null) {
		    leftChild.rChild.parent = node;
		  }

		  leftChild.rChild = node;
		  node.parent = leftChild;

		  ReplaceChild(parent, node, leftChild);
	}
	private void ReplaceChild(RedBlackTree<V>.Node parent, RedBlackTree<V>.Node oldChild, RedBlackTree<V>.Node newChild) {
		  if (parent == null) {
		    root = newChild;
		  } else if (parent.lChild == oldChild) {
		    parent.lChild = newChild;
		  } else if (parent.rChild == oldChild) {
		    parent.rChild = newChild;
		  } else {
		    throw new IllegalStateException("Node is not a child of ");
		  }

		  if (newChild != null) {
		    newChild.parent = parent;
		  }
	}


	@SuppressWarnings("unused")
	private RedBlackTree<V>.Node findLocNode(V elem) {
		Node prevNode = null;
		Node currentNode = root;
		
		while(currentNode != sentLeaf) {
			prevNode = currentNode;
			
			if (currentNode.elem.compareTo(elem) < 0) {
				currentNode = currentNode.rChild;
			} else {
				currentNode = currentNode.lChild;
			}
		}
		
		return prevNode;
	}

	@Override
	public void remove(V elem) {
		// TODO Auto-generated method stub
		Node node = root;

		 // Find the node to be deleted
		 while (node != null && node.elem != elem) {
		   // Traverse the tree to the left or right depending on the key
		   if (node.elem.compareTo(elem)>0) {
		     node = node.lChild;
		   } else {
		     node = node.rChild;
		   }
		 }
		// Node not found?
		 if (node == null) {
		   return;
		 }
		 
		 Node NodeGoesUp;
		 boolean deletedColor;

		 // Node has zero or one child
		 if (node.lChild == null || node.rChild == null) {
			 NodeGoesUp = deleteNodeWithLessThan2(node);
		   deletedColor = node.color;
		 }

		 // Node has two children
		 else {
		  
		   Node inOrderSuccessor = inOrderTraversal(node.rChild);
		   node.elem = inOrderSuccessor.elem;
		   NodeGoesUp = deleteNodeWithLessThan2(inOrderSuccessor);
		   deletedColor = inOrderSuccessor.color;
		 }
		 if (deletedColor == BLACK) {
			 fixDelete(NodeGoesUp);
			  if (NodeGoesUp.getClass() == NilNode.class) {
				  ReplaceChild(NodeGoesUp.parent, NodeGoesUp, null);
			  }
		 }
		 --count;

	}
	private Node deleteNodeWithLessThan2(RedBlackTree<V>.Node node) {
		  if (node.lChild != null) {
			  ReplaceChild(node.parent, node, node.lChild);
		    return node.lChild; // moved-up node
		  }
		  else if (node.rChild != null) {
			  ReplaceChild(node.parent, node, node.rChild);
		    return node.rChild; // moved-up node
		  }
		  else {
		    Node newChild = node.color == BLACK ? new NilNode() : null;
		    ReplaceChild(node.parent, node, newChild);
		    return newChild;
		  }
	}
	private void fixDelete(RedBlackTree<V>.Node node) {
		  // Case 1: Examined node is root, end of recursion
		  if (node == root){
		    return;
		  }

		  Node sibling = getSibling(node);

		  // Case 2: Red sibling
		  if (sibling.color == RED) {
			  HandlesRedSibling(node, sibling);
		    sibling = getSibling(node); 
		  }

		  // Cases 3+4: Black sibling with two black children
		  if (isBlack(sibling.lChild) && isBlack(sibling.rChild)) {
		    sibling.color = RED;

		    // Case 3: Black sibling with two black children + red parent
		    if (node.parent.color == RED) {
		      node.parent.color = BLACK;
		    }

		    // Case 4: Black sibling with two black children + black parent
		    else {
		      fixDelete(node.parent);
		    }
		  }

		  // Case 5+6: Black sibling with at least one red child
		  else {
			  HandlesBlackSiblingHasOneRedChild(node, sibling);
		  }
	}
	private Node getSibling(RedBlackTree<V>.Node node) {
		  Node parent = node.parent;
		  if (node == parent.lChild) {
		    return parent.rChild;
		  } else if (node == parent.rChild) {
		    return parent.lChild;
		  } else {
		    throw new IllegalStateException("Parent is not related to its grandparent");
		  }
	}

	private boolean isBlack(RedBlackTree<V>.Node node) {
	  return (node == null || node.color == BLACK);
	}
	private void HandlesRedSibling(RedBlackTree<V>.Node node, RedBlackTree<V>.Node sibling) {
		 sibling.color = BLACK;
		 node.parent.color = RED;
		 if (node == node.parent.lChild) {
		   rotateLeft(node.parent);
		 } else {
		   rotateRight(node.parent);
		 }
	}
	
	private void HandlesBlackSiblingHasOneRedChild(RedBlackTree<V>.Node node, RedBlackTree<V>.Node sibling) {
		 boolean nodeIsLeftChild = node == node.parent.lChild;

		  // Case 5: Black sibling with at least one red child + outer nephew is black
		 if (nodeIsLeftChild && isBlack(sibling.rChild)) {
		   sibling.lChild.color = BLACK;
		   sibling.color = RED;
		   rotateRight(sibling);
		   sibling = node.parent.rChild;
		 } else if (!nodeIsLeftChild && isBlack(sibling.lChild)) {
		   sibling.rChild.color = BLACK;
		   sibling.color = RED;
		   rotateLeft(sibling);
		   sibling = node.parent.lChild;
		 }

		 sibling.color = node.parent.color;
		 node.parent.color = BLACK;
		 if (nodeIsLeftChild) {
		   sibling.rChild.color = BLACK;
		   rotateLeft(node.parent);
		 } else {
		   sibling.lChild.color = BLACK;
		   rotateRight(node.parent);
		 }
	}

	@Override
	public boolean find(V elem) {
		// TODO Auto-generated method stub
		Node node = root;
		  while (node != null) {
		    if (elem == node.elem) {
		      return true;
		    } else if (node.elem.compareTo(elem)>0) {
		      node = node.lChild;
		    } else {
		      node = node.rChild;
		    }
		 }	 
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	public Node inOrderTraversal(RedBlackTree<V>.Node node) {
		while (node.lChild != null) {
		    node = node.lChild;
		  }
		  return node;
	}

	public  class Node {
		public Node(V elm) {
			elem = elm;
		}
		public Node(int i) {
		}

		V elem;
		Node parent;
		Node rChild;
		Node lChild;
		boolean color;
	}
	private class NilNode extends Node {
		 

		private NilNode() {
			super(0);
		    this.color = BLACK;
		  }
		}
	@Override
	public String inOrderTraversal() {
		return null;
	}
	
	private void printTreeBuilder(RedBlackTree<V>.Node root, String tab, boolean last) {
	    if (root != null) {
	      System.out.print(tab);
	      if (last) {
	        System.out.print("R----");
	        tab += "   ";
	      } else {
	        System.out.print("L----");
	        tab += "|  ";
	      }

	      String NodeColor = root.color == RED ? "RED" : "BLACK";
	      System.out.println(root.elem + "(" + NodeColor + ")");
	      printTreeBuilder(root.lChild, tab, false);
	      printTreeBuilder(root.rChild, tab, true);
	    }
	 }
	public void printTree() {
		printTreeBuilder(this.root, "", true);
	 }

}
