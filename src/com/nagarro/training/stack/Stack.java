package com.nagarro.training.stack;

import java.util.Iterator;

import com.nagarro.training.linkedList.*;

public class Stack implements Iterator<Integer>{

	int length = 0;
	Node top = null;

	public Stack() {

	}

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	// push
	public void push(int data) {
		Node tempNode = new Node(data);
		tempNode.setNextNode(top);
		top = tempNode;
		length++;
		System.out.println(data+" pushed in stack");
	}

	// pop
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		Node node = top;
		top = top.getNextNode();
		length--;
		return node.getData();
	}

	// peek
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		}
		return top.getData();
	}

	// Print
	public void display() {
		if (top != null) {
			Node currentNode = top;
			while (currentNode.getNextNode() != null) {
				System.out.println(currentNode.getData());
				currentNode = currentNode.getNextNode();
			}
			System.out.println(currentNode.getData());
		}
	}

	// Contains
	public boolean contains(int value) {
		if (isEmpty())
			return false;
		else {
			Node temp = this.top;
			if (temp.getData() == value)
				return true;
			while (temp != null && temp.getData() != value) {
				temp = temp.getNextNode();
			}
			if (temp != null)
				return true;

			return false;
		}
	}

	// Center
	public Node center() {

		if (isEmpty())
			return null;

		Node slow = this.top;
		Node fast = this.top;

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

	// Reverse
	public void reverse() {
		Node previous = null;
		Node current = this.top;
		Node next;
		while (current != null) {
			next = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = next;
		}
		this.top = previous;
	}

	// Sorting
	public void sort() {
		// Node current will point to head
		Node current = top, index = null;
		int temp;

		if (top == null) {
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
	
	// Iterator
	private int index = 0;
	
	public Stack iterator() {
		return this;
	}
	
	@Override
	public boolean hasNext() {
		return index < this.size();
	}
	
	@Override
	public Integer next() {
		Node temp = top;
		int var = index;
		
		while(var != 0) {
			temp = temp.getNextNode();
			var--;
		}
		index++;
		
		return temp.getData();
	}

}
