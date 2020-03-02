package HW2;


import java.util.*;

public class HashSet<AnyType>{



	private LinkedHashSet<LinkedHashSet<AnyType>> [] sets;
	private static final int DEFAULT_TABLE_SIZE = 7;
//	private Iterator iterator = sets.iterator();

	public HashSet(){
		this(DEFAULT_TABLE_SIZE);
	}

	public HashSet(int size){
		sets = new LinkedHashSet<AnyType>(nextPrime(size));
		for (int i=0;i<sets.length;i++)
			sets[i] = new LinkedHashSet<>();
	}

	public void insert(AnyType x){

	}

	private int hash(AnyType x){
		int hashValue = x.hashCode();

		hashValue %= sets.size();

		if (hashValue < 0)
			hashValue += sets.size();

		return hashValue;
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

	}
}
