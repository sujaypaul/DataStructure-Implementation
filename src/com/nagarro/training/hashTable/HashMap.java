package com.nagarro.training.hashTable;

import java.util.ArrayList;
import java.util.Iterator;

public class HashMap<K, V> implements Iterator<Pair<K, V>> {

	private List<Pair<K, V>>[] values;
	private int firstFreeIndex;
	private int noOfElement = 0;
	public ArrayList<K> arr = new ArrayList<>();

	public int size() {
		return noOfElement;
	}

	@SuppressWarnings("unchecked")
	public HashMap() {
		this.values = new List[32];
		this.firstFreeIndex = 0;
	}

	// Retrieving a Value
	public V get(K key) {
		int hashValue = Math.abs(key.hashCode() % this.values.length);
		if (this.values[hashValue] == null) {
			return null;
		}

		List<Pair<K, V>> valuesAtIndex = this.values[hashValue];

		for (int i = 0; i < valuesAtIndex.size(); i++) {
			if (valuesAtIndex.value(i).getKey().equals(key)) {
				return valuesAtIndex.value(i).getValue();
			}
		}

		return null;
	}

	// Adding to HashMap
	private List<Pair<K, V>> getListBasedOnKey(K key) {
		int hashValue = Math.abs(key.hashCode() % values.length);
		if (values[hashValue] == null) {
			values[hashValue] = new List<>();
		}

		return values[hashValue];
	}

	private int getIndexOfKey(List<Pair<K, V>> myList, K key) {
		for (int i = 0; i < myList.size(); i++) {
			if (myList.value(i).getKey().equals(key)) {
				return i;
			}
		}

		return -1;
	}

	// add
	public void insert(K key, V value) {
		List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
		int index = getIndexOfKey(valuesAtIndex, key);

		if (index < 0) {
			valuesAtIndex.add(new Pair<>(key, value));
			this.firstFreeIndex++;
			arr.add(key);
		} else {
			valuesAtIndex.value(index).setValue(value);
			arr.add(key);
		}

		if (1.0 * this.firstFreeIndex / this.values.length > 0.75) {
			grow();
		}
		noOfElement++;
	}

	// copies the list of values at one index of the old array into the new one
	private void copy(List<Pair<K, V>>[] newArray, int fromIdx) {
		for (int i = 0; i < this.values[fromIdx].size(); i++) {
			Pair<K, V> value = this.values[fromIdx].value(i);

			int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
			if (newArray[hashValue] == null) {
				newArray[hashValue] = new List<>();
			}

			newArray[hashValue].add(value);
		}
	}

	// growing functionality
	@SuppressWarnings("unchecked")
	private void grow() {
		// create a new array
		List<Pair<K, V>>[] newArray = new List[this.values.length * 2];

		for (int i = 0; i < this.values.length; i++) {
			// copy the values of the old array into the new one
			copy(newArray, i);
		}

		// replace the old array with the new
		this.values = newArray;
	}

	// Remove with key
	public V remove(K key) {
		List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
		if (valuesAtIndex.size() == 0) {
			return null;
		}

		int index = getIndexOfKey(valuesAtIndex, key);
		if (index < 0) {
			return null;
		}

		Pair<K, V> pair = valuesAtIndex.value(index);
		valuesAtIndex.remove(pair);
		noOfElement--;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(key))
				arr.remove(i);
		}

		return pair.getValue();
	}

	// Traversing and Printing
	public void display() {
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i)+" : "+this.get(arr.get(i)));
		}
	}

	// Contains
	public K contains(V value) {
		for (int i = 0; i < 32; i++) {
			if (values[i] != null)
				for (int j = 0; j < values[i].size(); j++) {
					if (values[i].get(j).getValue().equals(value))
						return values[i].get(j).getKey();
				}
		}
		return null;
	}

	// Iterator
	int itrCounter = -1;

	public HashMap<K, V> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return itrCounter < size() - 1;
	}

	@Override
	public Pair<K, V> next() {
		itrCounter++;

		Pair<K, V> result = new Pair<K, V>(
				(K) arr.get(itrCounter), 
				(V) this.get(arr.get(itrCounter)));
		return result;

	}

}
