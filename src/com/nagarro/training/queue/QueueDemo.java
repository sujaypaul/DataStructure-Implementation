package com.nagarro.training.queue;


public class QueueDemo {

	public static void main(String[] args) {

		Queue myQueue = new Queue();

        myQueue.enqueue(1);
        myQueue.enqueue(3);
        myQueue.enqueue(36);
        myQueue.enqueue(44);
        myQueue.enqueue(15);
        myQueue.enqueue(17);
        myQueue.enqueue(15);
        myQueue.enqueue(12);
        System.out.println("________________________");
        
        System.out.println("size of the queue now is "+ myQueue.size());
        
        System.out.println(myQueue.dequeue()+" popped from the queue");
        System.out.println(myQueue.dequeue()+" popped from the queue");
        System.out.println("size of the queue now is "+ myQueue.size());
        System.out.println("________________________");
        
        System.out.println("Front element of queue is "+myQueue.peek());
        
        if(myQueue.contains(44))
        	System.out.println("44 is present in the queue.");
        else
        	System.out.println("44 is not present in the queue.");
        if(myQueue.contains(43))
        	System.out.println("43 is present in the queue.");
        else
        	System.out.println("43 is not present in the queue.");
        
        System.out.println("__________________________");
        System.out.println("The center element of queue is "+myQueue.center().getData());
        System.out.println("________________________");
        
        System.out.println("queue before sorting");
        myQueue.display();
        myQueue.sort();
        System.out.println("queue after sorting");
        myQueue.display();
        System.out.println("________________________");
        System.out.println("queue after reverse");
        myQueue.reverse();
        myQueue.display();
        System.out.println();
        System.out.println("________________________");


        System.out.println("Displaying queue usig iterator");
        
        Queue itr = myQueue.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }
	}

}
