package Project;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ItemPacking {

	private static Item[] itemArray;
	private static BoxQueue queue;

	public ItemPacking(Item[] itemArray, BoxQueue queue){
		this.itemArray = itemArray;
		this.queue = queue;
	}

	public void givenOrder(){ //place items into boxes in the given order
		for(int i=0;i<itemArray.length;i++){
			double box = queue.remove();
			System.out.print(box + " --> ");

			if (box + itemArray[i].getWeight() <= 1.0)
				box+=itemArray[i].getWeight();

			queue.insert(box);
			System.out.println(box);
		}

	}

	public static void main(String[] args){
		Item[] arr = new Item[5];
		BoxQueue qu = new BoxQueue(6);

		for (int i=0;i<5;i++) {
	//		arr[i] = new Item(.5);
			qu.insert(1.0);
		}
		qu.remove();
		qu.insert(1.2);

//
//		ItemPacking pack = new ItemPacking(arr,qu);
//		pack.givenOrder();

		while(!qu.isEmpty()){
			System.out.println(qu.remove());
		}

	}
}
