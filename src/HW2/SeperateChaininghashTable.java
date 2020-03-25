package HW2;

import Classwork.QuadraticProbingHashTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

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
		double loadFactor = currentSize/theLists.length;

		if (!whichList.contains(x)) {
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

	private void reHash(){
		List<AnyType> [] oldList = theLists;

		theLists = new List[nextPrime(2 * theLists.length)];
		for (int i=0;i<theLists.length;i++){
			theLists[i] = new LinkedList<>();
		}

		currentSize = 0;
		for (int i=0; i<oldList.length;i++){
			for (AnyType item : oldList[i])
				insert(item);
		}
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

	public static void main(String[] args) throws Exception {

		SeperateChaininghashTable ints = new SeperateChaininghashTable(1009);

		long currentTime = System.currentTimeMillis();
		for (int i= 0;i<500;i++){
			ints.insert((int)(Math.random()*100));
		}
		System.out.println(ints.contains(99));
		System.out.println(ints.contains(55));
		System.out.println(ints.contains(11));
		System.out.println(System.currentTimeMillis()-currentTime);


		SeperateChaininghashTable strings = new SeperateChaininghashTable(500);
		currentTime = System.currentTimeMillis();
		for (int i= 0;i<500;i++){
			strings.insert(""+(Math.random()*100));
		}
		System.out.println(strings.contains("99"));
		System.out.println(strings.contains("55"));
		System.out.println(strings.contains("11"));
		System.out.println(System.currentTimeMillis()-currentTime);


		SeperateChaininghashTable<String> ht = new SeperateChaininghashTable<>(500);
		File file = new File("/home/evan/IdeaProjects/CIS442/src/HW2/500-worst-passwords.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		currentTime = System.currentTimeMillis();
		String st;
		while ((st = br.readLine()) != null)
			ht.insert(st);



		System.out.println(ht.contains("biteme"));
		System.out.println(ht.contains("TrumpMAGATrump"));
		System.out.println(ht.contains("ILoveAlgorithms"));
		System.out.println(System.currentTimeMillis()-currentTime);
	}

}
