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
		BoxQueue qu = new BoxQueue(5);

		for (int i=0;i<qu.size;i++) {
			arr[i] = new Item(.5);
			qu.insert(0.0);
		}


		ItemPacking pack = new ItemPacking(arr,qu);
		pack.givenOrder();

		while(!queue.isEmpty()){
			System.out.println(queue.remove());
		}

	}
}
