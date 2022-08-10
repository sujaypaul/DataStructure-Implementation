package com.nagarro.training.linkedList;

import java.util.Iterator;

public abstract class LinkedList implements Iterator<Integer>{
	private Node head;

	int length = 0;

	public LinkedList() {
	}

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	// Insertion
	public void insert(int data) {
		length++;
		Node newNode = new Node(data);
		if (this.head == null) {
			head = newNode;
		} else {
			Node currentNode = head;
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(newNode);
			System.out.println(data+" inserted in Linked List");
		}
	}

	public void insertHead(int data) {
		length++;
		Node newNode = new Node(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}

	// Insert at position
	public void insertAt(int index, int data) {
		length++;
		Node nodeToBeInserted = new Node(data);
		Node node = head;
		for (int i = 0; i < index - 1; i++) {
			node = node.getNextNode();
		}
		nodeToBeInserted.setNextNode(node.getNextNode());
		node.setNextNode(nodeToBeInserted);
	}

	// Delete at position
	public void deleteNodeAt(int index) {
		length--;
		Node node = this.head;

		if (index == 0)
			this.head = node.getNextNode();

		for (int i = 0; i < index - 1; i++) {
			node = node.getNextNode();
		}
		int dvalue = node.getNextNode().getData();
		node.setNextNode(node.getNextNode().getNextNode());
		System.out.println("deleted " + dvalue + " at index " + index);
	}

	// Delete by value
	public void deleteValue(int value) {
		Node currNode = this.head, prev = null;
		// if head is to be deleted
		if (currNode != null && currNode.getData() == value) {
			this.head = currNode.getNextNode();
			System.out.println(value + " fonnd and deleted at index ");
		}
		// if value to be deleted is other than head
		while (currNode != null && currNode.getData() != value) {
			prev = currNode;
			currNode = currNode.getNextNode();
		}
		if (currNode != null) {
			prev.setNextNode(currNode.getNextNode());
			System.out.println(value + " fonnd and deleted");
		}
		if (currNode == null) {
			System.out.println(value + " not fonnd");
		}
	}

	// Traversing and printing
	public void display() {
		if (head != null) {
			Node currentNode = head;
			while (currentNode.getNextNode() != null) {
				System.out.println(currentNode.getData());
				currentNode = currentNode.getNextNode();
			}
			System.out.println(currentNode.getData());
		}
	}

	// Reverse
	public void reverse() {
		Node previous = null;
		Node current = this.head;
		Node next;
		while (current != null) {
			next = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = next;
		}
		this.head = previous;
	}

	// center
	public Node center() {

		if (isEmpty())
			return null;

		Node slow = this.head;
		Node fast = this.head;

		while (slow.getNextNode() != null && fast.getNextNode() != null) {
			if (fast.getNextNode().getNextNode() == null) {
				fast = fast.getNextNode();
				return slow.getNextNode();
			} else {
				fast = fast.getNextNode().getNextNode();
				slow = slow.getNextNode();
			}
		}
		return slow;
	}

	// Sorting
	public void sort() {
		// Node current will point to head
		Node current = head, index = null;
		int temp;

		if (head == null) {
			return;
		} else {
			while (current != null) {
				// Node index will point to node next to current
				index = current.getNextNode();

				while (index != null) {
					// If current node's data is greater than index's node data, swap the data
					// between them
					if (current.getData() > index.getData()) {
						temp = current.getData();
						current.setData(index.getData());
						index.setData(temp);
					}
					index = index.getNextNode();
				}
				current = current.getNextNode();
			}
		}
	}
	
// Iterators	
	private int index = 0;
	
	public LinkedList iterator() {
		return this;
	}
	
	@Override
	public boolean hasNext() {
		return index < this.size()-1;
	}
	
	@Override
	public Integer next() {
		Node temp = head;
		int var = index;
		
		while(var != 0) {
			temp = temp.getNextNode();
			var--;
		}
		index++;
		
		return temp.getData();
	}
	
	

}
