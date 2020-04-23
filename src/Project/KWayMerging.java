package Project;

import java.util.*;
import java.util.List;

public class KWayMerging {

	public static ArrayList<Integer> KWay(ArrayList<ArrayList<Integer>> list){
		ArrayList<Integer> sorted = new ArrayList<>(list.size()*list.size());

		sorted = merging(list, sorted);

		return sorted;
	}

	private static ArrayList<Integer> merging(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> sorted){

		if(lists.size() == 2)
			sorted = mer(lists.get(0), lists.get(1));

		else{
			merging(breakdown(lists,0,lists.size()/2), sorted);
			merging(breakdown(lists,(lists.size()/2)+1, lists.size()-1), sorted);
		}

		return sorted;
	}

	private static ArrayList<ArrayList<Integer>> breakdown(ArrayList<ArrayList<Integer>> list, int start, int stop){
		ArrayList<ArrayList<Integer>> newList = new ArrayList<>();

		for (int i = start;i<stop;i++){
			newList.add(list.get(i));
		}

		return newList;
	}

	private static ArrayList<Integer> mer(ArrayList<Integer> list1, ArrayList<Integer> list2){
		int a=0, b=0;
		ArrayList<Integer> sorted = new ArrayList<>(list1.size()*list2.size());

		if (list2.isEmpty()) {
			return list1;
		}
		else {
			for (int i = 0; i <= list1.size()+list2.size()-1; i++) {
				if (a == list1.size()) {
					sorted.add(list2.get(b));
					b++;
				} else if (b == list2.size()) {
					sorted.add(list1.get(a));
					a++;
				} else if (list1.get(a) < list2.get(b)) {
					sorted.add(list1.get(a));
					a++;
				} else if (list2.get(b) < list1.get(a)) {
					sorted.add(list2.get(b));
					b++;
				}
			}
		}
		return sorted;
	}


	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		ArrayList<Integer> list4 = new ArrayList<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		{
			for (int i = 1; i < 8; i += 2)
				list1.add(i);
			for (int i = 2; i <= 8; i += 2)
				list2.add(i);
			for (int i = 10; i < 18; i += 2)
				list3.add(i);
			for (int i = 11; i < 18; i += 2)
				list4.add(i);
		}

		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);

		//KWayMerging merge = new KWayMerging(list);
	//	KWay(list);


		ArrayList<Integer> sort = KWay(list);
	//	ArrayList<ArrayList<Integer>> a = breakdown(list,0,list.size()/2);
		//System.out.print(a.size());

		for(int i =0;i<sort.size();i++){
			System.out.print(sort.get(i) + ", ");
		}
		System.out.println();
	}
}
