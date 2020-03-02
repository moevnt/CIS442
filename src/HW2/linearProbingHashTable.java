package HW2;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class linearProbingHashTable<AnyType> {

	public linearProbingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}

	public linearProbingHashTable(int size){
		allocateArray(size);
		makeEmpty();
	}

	public void makeEmpty(){
		currentSize = 0;

		for(int i=0; i< array.length;i++)
			array[i] = null;
	}

	public boolean contains(AnyType x){
		int currentPos = findPos(x);
		return isActive(currentPos);
	}

	public void insert(AnyType x){
		int currentPos = findPos(x);
		if(isActive(currentPos))
			return;

		array[currentPos] = new HashEntry<>(x,true);

		if(++currentSize > array.length/2)
			rehash();
	}

	public void remove(AnyType x){
		int currentPos = findPos(x);
		if(isActive(currentPos)) {
			array[currentPos].isActive = false;
			array[currentPos] = null;
		}
	}

	private static class HashEntry<AnyType>{
		public AnyType element;
		public boolean isActive;

		public HashEntry(AnyType e){
			this(e, true);
		}

		public HashEntry(AnyType e, boolean i){
			element = e;
			isActive = i;
		}
	}

	private static final int DEFAULT_TABLE_SIZE = 11;

	private HashEntry<AnyType> [] array;
	private int currentSize;

	private void allocateArray( int arraySize ){
		array = new HashEntry[nextPrime(arraySize)];
	}

	private boolean isActive( int currentPos ){
		return array[currentPos] != null && array[currentPos].isActive;
	}

	private int findPos( AnyType x ){
		int offset = 1;
		int currentPos = myhash(x);

		while(array[currentPos] != null && !array[currentPos].element.equals(x)){
			currentPos++;
//			offset += 2;
			if(currentPos >= array.length)
				currentPos = 0;
		}
		return currentPos;
	}

	private int myhash( AnyType x ){
		int hashValue = x.hashCode();

		hashValue %= array.length;

		if (hashValue < 0)
			hashValue += array.length;

		return hashValue;
	}

	private void rehash(){
		HashEntry<AnyType> [] oldArray = array;

		allocateArray(nextPrime(2*oldArray.length));
		currentSize = 0;

		for(int i=0;i<oldArray.length;i++)
			if (oldArray[i] != null && oldArray[i].isActive)
				insert(oldArray[i].element);

	}


	private static int nextPrime(int n){
		if(n % 2 == 0)
			n++;
		for(; !isPrime(n); n+=2)
			;
		return n;
	}

	private static boolean isPrime(int n){
		if(n==2 || n==3)
			return true;
		if (n==1 || n%2==0)
			return false;
		for(int i=3;i*i <= n; i+=2){
			if(n%i==0)
				return false;
		}
		return true;
	}

	public void printTable(){
		for(int i=0;i<array.length;i++){
			if (array[i] == null)
				System.out.println(i + "---->" + "empty");
			else if (array[i] != null)
				System.out.println(i + "---->" + array[i].element);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		linearProbingHashTable lt = new linearProbingHashTable(11);



		lt.insert(4592);
		lt.insert(4593);
		lt.insert(4581);
		lt.insert(11);
		lt.insert(22);



		lt.printTable();
	}

}
