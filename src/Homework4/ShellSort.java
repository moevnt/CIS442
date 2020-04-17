package Homework4;

public class ShellSort {

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

	public static <AnyType extends Comparable<AnyType>> void shellSortHibbard(AnyType[] list) {

		int j;

		int k;
		for (k = 1; Math.pow(2, k) - 1 < list.length; k++) {

		}
			for (int m = k; m >= 2; m--) {

				int gap = (int) (Math.pow(2, m) - 1);
				for (int i = gap; i < list.length; i++) {

					AnyType tmp = list[i];
					for (j = i; j >= gap && tmp.compareTo(list[j - gap]) < 0; j -= gap)
						list[j] = list[j - gap];

					list[j] = tmp;
				}
			}

	}
	public static <AnyType extends Comparable<AnyType>> void shellSortKnuth(AnyType[] list) {

		int j;

		int k;
		for (k = 1; .5*(Math.pow(3,k)+1) < list.length; k++) {

		}

		for (int m = k; m >= 2; m--) {

			int gap = (int) (Math.pow(2, m) - 1);
			for (int i = gap; i < list.length; i++) {

				AnyType tmp = list[i];
				for (j = i; j >= gap && tmp.compareTo(list[j - gap]) < 0; j -= gap)
					list[j] = list[j - gap];

				list[j] = tmp;
			}
		}
	}

	private static int gonnetFloor( double n){
		return (int) Math.floor(n);
	}

	public static <AnyType extends Comparable<AnyType>> void shellSortGonnet(AnyType[] list) {

		int j;

		int k;
		for (k = 1; gonnetFloor(list.length/2.2) < list.length; k++) {

		}

		for (int m = k; m >= 2; m--) {

			int gap = (int) (Math.pow(2, m) - 1);
			for (int i = gap; i < list.length; i++) {

				AnyType tmp = list[i];
				for (j = i; j >= gap && tmp.compareTo(list[j - gap]) < 0; j -= gap)
					list[j] = list[j - gap];

				list[j] = tmp;
			}
		}
	}

	private static int sedgewick(int i){
		return (int) (Math.pow(4, i) + 3*Math.pow(2,i-1)+1);
	}
	public static <AnyType extends Comparable<AnyType>> void shellSortSedgewick(AnyType[] list) {

		int j;

		int k;
		for (k = 1;  sedgewick(k) < list.length; k++) {

		}

		for (int m = k; m >= 2; m--) {

			int gap = (int) (Math.pow(2, m) - 1);
			for (int i = gap; i < list.length; i++) {

				AnyType tmp = list[i];
				for (j = i; j >= gap && tmp.compareTo(list[j - gap]) < 0; j -= gap)
					list[j] = list[j - gap];

				list[j] = tmp;
			}
		}
	}

	public static void main(String[] args){
		Integer[] list = new Integer[50];

		for(int i=0;i< list.length;i++)
			list[i] = 1 + (int) (Math.random() * 100);

		printArray(list);
		shellSortHibbard(list);
		printArray(list);
	}

	private static<AnyType> void printArray(AnyType[] list){
		for(AnyType item:list){
			System.out.print(item + " ");
		}
		System.out.println();
	}
}
