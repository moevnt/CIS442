package Classwork;

import java.util.List;
import java.util.LinkedList;

public class SeperateChaininghashTable<AnyType> {

	private static final int DEFAULT_TABLE_SIZE = 7;
	private List<AnyType> [] theLists;
	private int currentSize;

	public SeperateChaininghashTable(){
		this(DEFAULT_TABLE_SIZE);
	}

	public SeperateChaininghashTable(int size){
			theLists = new LinkedList[nextPrime(size)];
			for(int i=0;i<theLists.length;i++)
				theLists[i] = new LinkedList<>();
	}

	public void insert(AnyType x){
		List<AnyType> whichList = theLists[hash(x)];
		if(!whichList.contains(x)){
			whichList.add(x);
			currentSize++;
		}
	}

	public boolean contains(AnyType x){
		List<AnyType> whichList = theLists[hash(x)];
		return whichList.contains(x);
	}

	public void remove(AnyType x){
		List<AnyType> whichList = theLists[hash(x)];
		if(whichList.contains(x)) {
			whichList.remove(x);
			currentSize--;
		}
	}

	public void printTable(){
		for(List<AnyType> list : theLists){
			for (AnyType element : list)
				System.out.print(element.toString() + " ---->");
			System.out.println();
		}
	}

	private int hash(AnyType x){
		int hashValue = x.hashCode();

		hashValue %= theLists.length;

		if (hashValue < 0)
			hashValue += theLists.length;

		return hashValue;
	}

	private int reHash(AnyType x){
		return hash(x);
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

	public static void main(String[] args){
		SeperateChaininghashTable<Character> ht = new SeperateChaininghashTable<>();


		ht.insert('b');
		ht.insert('c');
		ht.insert('d');
		ht.insert('a');

		ht.printTable();
	}

}
