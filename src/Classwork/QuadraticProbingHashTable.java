package Classwork;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class QuadraticProbingHashTable<AnyType> {

	public QuadraticProbingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}

	public QuadraticProbingHashTable(int size){
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
			currentPos += offset;
			offset += 2;
			if(currentPos >= array.length)
				currentPos -= array.length;

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

	public static void main(String[] args) throws Exception {
		QuadraticProbingHashTable ints = new QuadraticProbingHashTable(1009);

		long currentTime = System.currentTimeMillis();
		for (int i= 0;i<500;i++){
			ints.insert((int)(Math.random()*100));
		}
		System.out.println(ints.contains(99));
		System.out.println(ints.contains(55));
		System.out.println(ints.contains(11));
		System.out.println(System.currentTimeMillis()-currentTime);


		QuadraticProbingHashTable strings = new QuadraticProbingHashTable(1009);
		currentTime = System.currentTimeMillis();
		for (int i= 0;i<500;i++){
			ints.insert(""+(Math.random()*100));
		}
		System.out.println(ints.contains("99"));
		System.out.println(ints.contains("55"));
		System.out.println(ints.contains("11"));
		System.out.println(System.currentTimeMillis()-currentTime);


		QuadraticProbingHashTable dictionary = new QuadraticProbingHashTable(1009);
		File file = new File("/home/evan/IdeaProjects/CIS442/src/HW2/500-worst-passwords.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		currentTime = System.currentTimeMillis();
		String st;
		for(int i=0;i<500;i++) {
			st = br.readLine();
			dictionary.insert(st);
		}


		System.out.println(dictionary.contains("biteme"));
		System.out.println(dictionary.contains("TrumpMAGATrump"));
		System.out.println(dictionary.contains("ILoveAlgorithms"));
		System.out.println(System.currentTimeMillis()-currentTime);
	}
}
