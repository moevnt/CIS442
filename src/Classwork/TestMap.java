package Classwork;

//import java.util.Map;
import java.util.*;
public class TestMap {

	private Map<String, String> map;

	public TestMap(){
		map = new TreeMap<>();
	}

	public void insert(String x, String y){
		if (!map.containsKey(x))
			map.put(x,y);

		Set<String> keys = map.keySet();
	}

	public int size(){
		return map.size();
	}

	public  void printMap(){
		for (String key : map.keySet()){
			System.out.println(key + " --> " + map.get(key));
		}
	}

	private Set<String> keySet() {
		return map.keySet();
	}

	private Object get(Object key){
		return map.get(key);
	}

	private void remove(Object key){
		map.remove(key);
	}

	public  void swap(){
		Object[] tempKey = map.keySet().toArray();

		for(int i=0;i<map.size();i++){
			String tempValue =  map.get(tempKey[i]);
		//	System.out.println(tempKey[i]);
			map.put(tempValue,""+tempKey[i]);
			map.remove(tempKey[i]);
		}
	}

	public static void main(String[] args){
		TestMap map = new TestMap();

		map.insert("Evan", "A");
		map.insert("Angel", "D");
		map.insert("Alex", "F");
		map.insert("Johnny", "B");
		map.insert("Sullivan", "C");


		System.out.println(map.size());
		map.printMap();
		System.out.println();
		map.swap();
		map.printMap();
	}
}
