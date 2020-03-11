package Classwork;

public class SortingAlgorithms<AnyType extends Comparable<AnyType>>  {

	public static <AnyType extends Comparable<AnyType>> void bubbleSort(AnyType[] list){

		for(int i=0;i<list.length;i++) {
			for (int j = 0; j < list.length - 1; j++) {
				if (list[j + 1].compareTo(list[j]) < 0) {
					AnyType tmp = list[j + 1];
					list[j + 1] = list[j];
					list[j] = tmp;
				}
			}
		}
	}

	public static <AnyType extends Comparable<AnyType>> void selectionSort(AnyType[] list){

		for (int i=0;i<list.length;i++){
			AnyType currentMin = list[i];
			int currentMinIndex = i;

			for (int j=i+1;j<list.length;j++){
				if (currentMin.compareTo(list[j]) > 0){
					currentMin = list[j];
					currentMinIndex = j;
				}
			}

			if(currentMinIndex != i){
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}

		}
	}

	public static <AnyType extends Comparable<AnyType>> void insertionSort(AnyType[] list){

		int j;

		for (int p=1;p<list.length;p++){
			AnyType tmp = list[p];

			for (j = p;j > 0 && tmp.compareTo(list[j-1])<0;j--){
				list[j] = list[j-1];
			}

			list[j] = tmp;
		}
	}

	private static<AnyType> void printArray(AnyType[] list){
		for(AnyType item:list){
			System.out.print(item + " ");
		}
	}

	public static void main(String [] args){
		Integer[] list = new Integer[10];

		for(int i=0;i< list.length;i++)
			list[i] = 1+ (int)(Math.random()*100);

		printArray(list);
		insertionSort(list);
		System.out.println();
		printArray(list);
	}

}
