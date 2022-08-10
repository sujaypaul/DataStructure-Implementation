package com.nagarro.training.priorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();

		pq.add(45);
		pq.add(20);
		pq.add(14);
		pq.add(12);
		pq.add(301);
		pq.add(33);
		pq.add(11);
		pq.add(13);
		pq.add(46);
		System.out.println();
		System.out.println("Size of priority queue is "+pq.size());
		pq.center();
		
		System.out.println("element with the highest priority is "+pq.peek());
		
		System.out.println();
		if(pq.contains(301))
			System.out.println("301 is present");
		else
			System.out.println("301 is not present");
		
		System.out.println(pq.poll()+" with the highest priority is removed");
	

		
		if(pq.contains(301))
			System.out.println("301 is not present");
		else
			System.out.println("301 is not present");
		
		
		System.out.println();
		System.out.println(pq.peek()+" is now with the highest priority");
		
		
		pq.reverse();
		pq.add(100);
		System.out.println("After reverse");
		System.out.println(pq.peek()+" is the highest priority element");
		
		System.out.println();
		pq.printElements();
		
		System.out.println();
		System.out.println("Displaying using iterator");
		PriorityQueue itr = pq.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
