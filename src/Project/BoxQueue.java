package Project;

public class BoxQueue {

	private Double[] queue;
	private int currentSize;
	public int size;
	private final static int DEFAULT_CAPACITY = 10;

	public BoxQueue(){
		queue =  new Double[DEFAULT_CAPACITY];
		size = DEFAULT_CAPACITY;
		currentSize = 0;
	}

	public BoxQueue(int size){
		queue = new Double[size];
		this.size = size;
		currentSize = 0;
	}

	public void insert(double x) {

		if (currentSize < size) {
			queue[currentSize++] = x;
		}
	}

	public double remove(){
		int placement = 0;

		for (int i=0;i<size;i++){
			if (queue[placement] > queue[i])
				placement = i;
		}

		for(int i=placement;i<size-1;i++){
			queue[i+1] = queue[i];
		}
		currentSize--;
		return queue[placement];
	}

	public boolean isEmpty(){
		if (currentSize>0)
			return false;
		return true;
	}

}
