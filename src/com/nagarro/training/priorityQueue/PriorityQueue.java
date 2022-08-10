package com.nagarro.training.priorityQueue;
import java.util.ArrayList;
import java.util.Iterator;


class PriorityQueue implements Iterator<Integer>
{
    private ArrayList<Integer> A;
    private boolean maxHeap = true;
    int index=0;
    
    public PriorityQueue() {
        A = new ArrayList<>();
    }
 
    public PriorityQueue(int capacity) {
        A = new ArrayList<>(capacity);
    }
 
    private int parent(int i)
    {
        if (i == 0) {
            return 0;
        }
 
        return (i - 1) / 2;
    }
 
    private int LEFT(int i) {
        return (2*i + 1);
    }
 
    private int RIGHT(int i) {
        return (2*i + 2);
    }
 
    void swap(int x, int y)
    {
        Integer temp = A.get(x);
        A.set(x, A.get(y));
        A.set(y, temp);
    }
 
    private void heapifyDown(int i)
    {
    	if(maxHeap) {
    		int left = LEFT(i);
            int right = RIGHT(i);
     
            int largest = i;
     
            if (left < size() && A.get(left) > A.get(i)) {
                largest = left;
            }
     
            if (right < size() && A.get(right) > A.get(largest)) {
                largest = right;
            }
     
            if (largest != i)
            {
                swap(i, largest);
     
                heapifyDown(largest);
            }
    	}
    	
    	else {
    		int left = LEFT(i);
            int right = RIGHT(i);
     
            int largest = i;
     
            if (left < size() && A.get(left) < A.get(i)) {
                largest = left;
            }
     
            if (right < size() && A.get(right) < A.get(largest)) {
                largest = right;
            }
     
            if (largest != i)
            {
                swap(i, largest);
     
                heapifyDown(largest);
            }
    	}
        
    }
 
    private void heapifyUp(int i)
    {
    	if(maxHeap) {
    		if (i > 0 && A.get(parent(i)) < A.get(i))
            {
                swap(i, parent(i));
     
                heapifyUp(parent(i));
            }
    	}
    	else {
    		if (i > 0 && A.get(parent(i)) > A.get(i))
            {
                swap(i, parent(i));
     
                heapifyUp(parent(i));
            }
    	}
        
    }
 
    public int size() {
        return A.size();
    }
 
    public Boolean isEmpty() {
        return A.isEmpty();
    }
 
    public void add(Integer key)
    {
    	A.add(key);
        int index = size() - 1;
        heapifyUp(index);
    }
 
    public Integer poll()
    {
        
            if (size() == 0) {
                System.out.println("Index is out of range (Heap underflow)");
                return null;
            }
 
           int root = A.get(0);
            
            A.set(0, A.get(size()-1));
            A.remove(size() - 1);
 
            heapifyDown(0);
 
            return root;
        
       
    }
 
    public Integer peek()
    {

            if (size() == 0) {
            	System.out.println("Index is out of range (Heap underflow)");
            }
 
            return A.get(0);
        
       
    }
 

    public Boolean contains(Integer i) {
        return A.contains(i);
    }
 
    public Integer[] toArray() {
        return A.toArray(new Integer[size()]);
    }

    public static void main (String[] args)
    {
        PriorityQueue pq = new PriorityQueue(10);
 
        pq.add(3);
        pq.add(2);
        pq.add(15);

        pq.add(5);
        pq.add(4);
        pq.add(45);
        
        pq.add(55);
        pq.add(24);
        pq.add(145);

        pq.add(53);
        pq.add(34);
        pq.add(435);
 
        System.out.println("Priority queue size is " + pq.size());
 
        Integer searchKey = 3;
 
        if (pq.contains(searchKey)) {
            System.out.println("Priority queue contains " + searchKey + "\n");
        }
        else {
        	System.out.println(searchKey+" Not Present");
        }
 

        if (pq.isEmpty()) {
            System.out.println("The queue is empty");
        }
 

        pq.printElements();
        
        pq.center();
 
        System.out.println("\nThe element with the highest priority is " + pq.poll());
        System.out.println("Priority queue size is " + pq.size());
        pq.printElements();
        pq.center();
        
        System.out.println("The element with the highest priority is " + pq.peek());
        
        //pq.reverse();
        System.out.println("The reversed Queue is: " );
        pq.printElements();
        
        System.out.println("Iterating in the Queue: ");
        
        PriorityQueue itr = pq.iterator();

        while(itr.hasNext()) {
            System.out.print(itr.next() + "  ");
        }
    }

    //iterator    
    private int itrCounter = 0;

    public PriorityQueue iterator() {
		return this;
    }



    @Override
    public boolean hasNext() {
        return itrCounter<size();
    }

    @Override
    public Integer next() {
    	int temp = 0;
    	int var = itrCounter;
    	while(var!=0) {
    		temp++;
    		var--;
    	}
    	itrCounter++;
        return Integer.valueOf(A.get(temp));
    }

	public void reverse()
    {
        
        if(maxHeap) {
        	if(!isEmpty()) {
        		int x = poll();
        		reverse();
        		add(x);
        	}
        	maxHeap = false;
        }
        else {
        	if(!isEmpty()) {
        		int x = poll();
        		reverse();
        		add(x);
        	}
        	maxHeap = true;
        }
 
    }
 
    
    public void printElements()
    {
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + " ");
        }
        System.out.println();
    }

	public void center() {
		int item;
		if(A.size() % 2 == 0) {
			 item = A.get((A.size()/2) + (A.size() % 2));
		}
		else {
			 item = A.get((A.size()/2));
		}
		// item = A.get((A.size()/2));
		System.out.println("Center of the Queue is: "+ item);
		
	}
	
	
	
	
}