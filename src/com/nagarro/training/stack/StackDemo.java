package com.nagarro.training.stack;


public class StackDemo {

	public static void main(String[] args) {
		
		Stack myStack = new Stack();
        myStack.push(1);
        myStack.push(3);
        myStack.push(36);
        myStack.push(44);
        myStack.push(15);
        myStack.push(17);
        myStack.push(15);
        myStack.push(12);
        System.out.println("________________________");
        
        System.out.println("size of the stack now is "+ myStack.size());
        
        System.out.println(myStack.pop()+"popped from the stack");
        System.out.println(myStack.pop()+"popped from the stack");
        System.out.println("size of the stack now is "+ myStack.size());
        System.out.println("________________________");
        
        System.out.println("Top element of Stack is "+myStack.peek());
        
        if(myStack.contains(44))
        	System.out.println("44 is present in the stack.");
        else
        	System.out.println("44 is not present in the stack.");
        if(myStack.contains(43))
        	System.out.println("43 is present in the stack.");
        else
        	System.out.println("43 is not present in the stack.");
        
        System.out.println("__________________________");
        System.out.println("The center element of stack is "+myStack.center().getData());
        System.out.println("________________________");
        
        System.out.println("Stack before sorting");
        myStack.display();
        myStack.sort();
        System.out.println("Stack after sorting");
        myStack.display();
        System.out.println("________________________");
        System.out.println("stack after reverse");
        myStack.reverse();
        myStack.display();
        System.out.println();
        System.out.println("________________________");


        System.out.println("Displaying Stack usig iterator");
        
        Stack itr = myStack.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }

	}

}
