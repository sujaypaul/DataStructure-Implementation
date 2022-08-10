package com.nagarro.training.hashTable;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> num = new HashMap<String, Integer>();

		num.insert("one", 1);
		num.insert("two", 2);
		num.insert("three", 3);
		num.insert("four", 4);
		num.insert("five", 5);
		num.insert("six", 6);
		num.insert("seven", 7);
		num.insert("eight", 8);
		num.insert("nine", 9);

		System.out.println("size of hash table : "+num.size());
		
		System.out.println();
		System.out.println("Accessing value 6 with key \"six\"");
		System.out.println(num.get("six"));
		System.out.println();
		
		System.out.println("Removed "+num.remove("five"));
		
		System.out.println("size of hashtable now becomes "+num.size());
		System.out.println();
		
		System.out.println("Checking if a value is present :");
		
		if(num.contains(5)!=null)
			System.out.println("key found : "+num.contains(5));
		else
			System.out.println(6+" is not mapped to any key");
		
		if(num.contains(8)!=null)
			System.out.println("key found : "+num.contains(8));
		else
			System.out.println(6+" is not mapped to any key");
		
		
		System.out.println("________________________");
		System.out.println("Printing the HashTable with display()");
		num.display();
		System.out.println("________________________");

		
		HashMap<String, Integer> itr = num.iterator();
		
		while(itr.hasNext()) {
			String key = itr.next().getKey();
			Integer value = num.get(key);
			System.out.println(key+" : "+value);
		}
	}
}
