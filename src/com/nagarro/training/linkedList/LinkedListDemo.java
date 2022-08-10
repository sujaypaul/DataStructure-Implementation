package com.nagarro.training.linkedList;


public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList() {};
		
        ll.insert(5);
        ll.insert(10);
        ll.insert(11);
        ll.insert(10);
        ll.insert(20);
        ll.insert(2);
        ll.insert(24);
        ll.insert(45);
        System.out.println("________________________");

        ll.deleteNodeAt(3);
        System.out.println("Size after deletion "+ll.size());
        System.out.println("________________________");

        ll.deleteValue(20);
        System.out.println("Size after deletion "+ll.size());
        System.out.println("________________________");

        System.out.println("Center element of this Linked List is "+ ll.center().getData());
        System.out.println("________________________");
        

        ll.sort();
        System.out.println("After Sorting");
        ll.display();
        System.out.println("________________________");
        
        ll.reverse();
        System.out.println("After reversing : ");
        ll.display();
        System.out.println("________________________");

        
        
        System.out.println("Printing with help of iterator");
       
        LinkedList itr =ll.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }
        
        
	}

}
