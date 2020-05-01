package Project;

import Classwork.BinaryHeap;

import java.util.ArrayList;
import java.util.Stack;

public class KWayMerge {

	private static final BinaryHeap<Integer> heap = new BinaryHeap<>(4);

	public static ArrayList<Integer> Merge(ArrayList<Stack<Integer>> list){

		int n = list.size()*list.get(0).size();
		ArrayList<Integer> sorted = new ArrayList<>();
		initialFill(list);

		for (int i=0;i<n;i++){
			int min = heap.deleteMin();
			sorted.add(min);

			for (int j=0;j<list.size();j++){
				if (min == list.get(j).peek()) {
					list.get(j).pop();
					if (!list.get(j).isEmpty())
						heap.insert(list.get(j).peek());
				}
				if(list.get(j).isEmpty())
					list.remove(j);
			}
		}
		return sorted;
	}

	private static void initialFill(ArrayList<Stack<Integer>> list){
		for (Stack<Integer> integers : list) {
			heap.insert(integers.peek());
		}
	}

	public static void main(String[] args){
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		Stack<Integer> s3 = new Stack<>();
		Stack<Integer> s4 = new Stack<>();

		for (int i=5;i>1;i--){
			s1.push(i*2);
			s2.push((i*2)-1);
			s3.push((i*2)+10);
			s4.push((i*2)+9);
		}
		
		ArrayList<Stack<Integer>> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);

		ArrayList<Integer> sort = Merge(list);

		print(sort);
	}

	private static void print(ArrayList<Integer> list){
		for(Object o : list) {
			System.out.print(o + " ");
		}
		System.out.println();
	}
}
