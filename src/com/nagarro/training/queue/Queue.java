package com.nagarro.training.queue;

import java.util.Iterator;

import com.nagarro.training.linkedList.*;

public class Queue implements Iterator<Integer> {
	private int length;
	private Node front, rear;

	public Queue() {
		length = 0;
		front = rear = null;
	}

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	// Enqueue
	public void enqueue(int data) {
		Node node = new Node(data);
		if (this.length == 0) {
			front = node;
		} else {
			rear.setNextNode(node);
		}
		rear = node;
		length++;
		System.out.println(data+" enqueued at queue");
	}

	// Dequeue
	public int dequeue() {
		if (this.length == 0) {
			System.out.println("Queue is empty");
			return -1;
		} 
		else {
			int result = front.getData();
			front = front.getNextNode();
			length--;
			if (this.length == 0) {
				rear = null;
			}
			return result;
		}
	}

	// Peek
	public int peek() {
		if (this.length == 0) {
			System.out.println("Stack is empty");
		}
		return front.getData();
	}

	// Print
	public void display() {
		if (front != rear.getNextNode()) {
			Node currentNode = front;
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
			Node temp = this.front;
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

		Node slow = this.front;
		Node fast = this.front;

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
		Node current = this.front;
		Node next;
		while (current != null) {
			next = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = next;
		}
		this.front = previous;
	}

	// Sorting
	public void sort() {
		// Node current will point to head
		Node current = front, index = null;
		int temp;

		if (front == null) {
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

	public Queue iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return index < this.size();
	}

	@Override
	public Integer next() {
		Node temp = front;
		int var = index;

		while (var != 0) {
			temp = temp.getNextNode();
			var--;
		}
		index++;

		return temp.getData();
	}

}
