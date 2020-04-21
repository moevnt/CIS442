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
				AnyType tmp =
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

	public static <AnyType extends Comparable<AnyType>> void shellSort(AnyType[] list){

		int j;

		for(int gap=list.length/2; gap>0; gap/=2){
			for (int i=gap; i<list.length; i++){
				AnyType tmp = list[i];
				for (j=i; j>= gap && tmp.compareTo(list[j-gap]) < 0; j -= gap){
					list[j] = list[j-gap];
				}
				list[j] = tmp;
			}
		}
	}

	public static <AnyType extends Comparable<AnyType>> void shellSortHibbard(AnyType[] list){

		int j;

		int k;
		for(k=1;Math.pow(2,k)-1 < list.length;k++){


		}
		for (int m = k;m<= 1; m--){

		int gap = (int)(Math.pow(2,m)-1);

		for(int i=gap; i< list.length; i++){
				AnyType tmp = list[i];
				for (j=i; j>= gap && tmp.compareTo(list[j-gap]) < 0; j -= gap){

					list[j] = list[j-gap];
				}
				list[j] = tmp;
			}
		}
	}

	

	public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a ){
		AnyType[] tmpArray = (AnyType[] ) new Comparable[a.length];
		mergeSort(a,tmpArray,0,a.length-1);
	}

	private static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a, AnyType[] tmpArray, int left, int right){
		if (left < right){
			int center = (left+right)/2;

			mergeSort(a,tmpArray,left,center);
			mergeSort(a,tmpArray,center+1,right);
			merge(a, tmpArray,left,center+1,right);
		}
	}

	private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] a, AnyType[] tmpArray, int leftPos, int rightPos, int rightEnd){

		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		while(leftPos <= leftEnd && rightPos <= rightEnd)
			if (a[leftPos].compareTo(a[rightPos]) <= 0)
				tmpArray[tmpPos++] = a[leftPos++];
			else
				tmpArray[tmpPos++] = a[rightPos++];

		while(leftPos <= leftEnd)
			tmpArray[tmpPos++] = a[leftPos++];

		while(rightPos <= rightEnd)
			tmpArray[tmpPos++] = a[rightPos++];

		for (int i=0; i<numElements; i++, rightEnd--)
			a[rightEnd] = tmpArray[rightEnd];
	}

	private static <AnyType extends Comparable<? super AnyType>> void percDown( AnyType [ ] a, int i, int n ) {
		int child;
		AnyType tmp;

		for( tmp = a[ i ]; 2*i+1 < n; i = child )
		{
			child = 2*i+1;
			if( child != n - 1 && a[ child ].compareTo( a[ child + 1 ] ) < 0 )
				child++;
			if( tmp.compareTo( a[ child ] ) < 0 )
				a[ i ] = a[ child ];
			else
				break;
		}
		a[ i ] = tmp;
	}

	public static <AnyType extends Comparable<? super AnyType>> void heapsort( AnyType [ ] a ) {
		for (int i = a.length / 2 - 1; i >= 0; i--)  /* buildHeap */
			percDown(a, i, a.length);
		for (int i = a.length - 1; i > 0; i--) {
			swapReferences(a, 0, i);                /* deleteMax */
			percDown(a, 0, i);
		}
	}

	public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 ) {
		AnyType tmp = a[ index1 ];
		a[ index1 ] = a[ index2 ];
		a[ index2 ] = tmp;
	}

	public static <AnyType extends Comparable<? super AnyType>> void quickSort(){

	}

	private static<AnyType> void printArray(AnyType[] list){
		for(AnyType item:list){
			System.out.print(item + " ");
		}
		System.out.println();
	}

	public static void main(String [] args){
		Integer[] list1 = {1,3,5,7,2};
		int[] list2 = {2,4,6,8};

		mergeSort(list1);
		printArray(list1);
	}



}
