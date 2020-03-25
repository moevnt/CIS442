package Classwork;

import java.nio.BufferUnderflowException;
import java.util.Stack;

public class BinaryHeap <AnyType extends Comparable<? super AnyType>> {

	private static final int DEFAULT_CAPACITY = 10;
	private int currentSize;
	private int[] array;
	private Stack<Integer> stack;

	public BinaryHeap(){
		this(DEFAULT_CAPACITY);
	}

	public BinaryHeap(int capacity){
		currentSize = 0;
		array = new int[capacity+1];
		stack = new Stack<Integer>();
	}

	public BinaryHeap(Integer[] items){
		currentSize = items.length;
		array = new int[(currentSize+2) * 11/10];
		int i=1;
		for (Integer item : items)
			array[i++] = item;
		buildHeap();
	}



	public void insert(Integer x){
		if (currentSize == array.length-1)
			enlargeArray(array.length*2+1);

		int hole = ++currentSize;

		percolateUp(x);

		if(stack.empty())
			stack.push(hole);

		else {
			Integer z = array[stack.peek()];
			if (z.compareTo(x) < 0)
				stack.push(hole);

		}
	}

	public Integer findMax(){
		if(isEmpty())
			throw new BufferUnderflowException();

		return array[stack.peek()];
	}

	public Integer findMin(){
		if(isEmpty())
			throw new BufferUnderflowException();
		return array[1];
	}

	public Integer deleteMin(){
		Integer minItem = findMin();
		array[1] = array[currentSize--];
		percolateDown(1);
		return minItem;
	}

	public boolean isEmpty(){
		return currentSize == 0;
	}

	public void makeEmpty(){
		currentSize = 0;
	}

	public void decreaseKey(int p, int delta){
		array[p] -= delta;
		percolateUp(array[p]);
	}

	public void increaseKey(int p, int delta){
		array[p] += delta;
		percolateDown(p);
	}

	public void delete(int p){
		increaseKey(p,array[p]+1);
		deleteMin();
	}

	private int getValue(int p){
		return Integer.parseInt(""+array[p]);
	}

	private void percolateUp(Integer x){

		int hole = currentSize;

		for (array[0]=x;x.compareTo(array[hole/2])<0;hole/=2) //place holder = input; if(input < parent); hole = parent
			array[hole] = array[hole/2];
		array[hole] = x;
	}

	private void percolateDown(int hole){
		int child ;
		int tmp = array[hole];

		for (;hole*2 <= currentSize;hole = child) {
			child = hole*2;
			if (child != currentSize && array[child + 1] < array[child])
				child++;

			if (array[child] < tmp)
				array[hole] = array[child];
			else
				break;

		}
		array[hole] = tmp;
	}

	private void buildHeap(){
		for (int i=currentSize/2;i>0;i--){
			percolateDown(i);
		}
	}

	private void enlargeArray(int newSize){
		int[] old = array;
		array = new int[newSize];
		for (int i=0;i<old.length;i++){
			array[i] = old[i];
		}
	}

	public void algorithm6A(int k) {

		buildHeap();
		for(int i = 0; i < k - 1; i++) {
			deleteMin();
		}
		System.out.println("The kth smallest element is: " + findMin());
	}

	public void algorithm6B(int k) {

		buildHeap();
		for(int i = 0; i < k - 1; i++) {
			deleteMin();
		}
		System.out.println("The kth smallest element is: " + findMin());
	}

	private void printHeap(){
		for (int i=1;i< currentSize+1;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}

	public static void main(String [] args){

		BinaryHeap<Integer> h = new BinaryHeap<>();
		int k = 4;
		int[] arr = {10,12,1,14,6,5,8,15,3,9,7,4,11,13,2};

		for(int i = 0; i < k; i++) {
			h.insert(arr[i]);
		}

		for(int i = k; i < arr.length; i ++) {
			if(arr[i] > h.findMin()) {
				h.deleteMin();
				h.insert(arr[i]);
			}
		}
		System.out.println("The kth largest element is: " + h.findMin());

		for(int i = 0; i < arr.length; i++) {
			h.insert(arr[i]);
		}

		h.algorithm6A(4);

		h.printHeap();
		h.deleteMin();
		h.printHeap();
		System.out.println(h.findMax());
		h.decreaseKey(9,60);
		h.increaseKey(4,15);
		h.delete(4);
		h.printHeap();

	}
}
