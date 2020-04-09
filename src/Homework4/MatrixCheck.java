package Homework4;

public class MatrixCheck {

	public static <AnyType extends Comparable<AnyType>> boolean matrixcheck(int[][] arr, int key){
		boolean result = false;

		for (int i =0;i<arr.length;i++){
			if (arr[i][arr.length-1] == key)
				result = true;
			else if (arr[i][arr.length-1] > key)
				for(int j=0;j<arr.length;j++){
					if (arr[i][j] == key)
						result = true;
				}
		}

		return result;

	}


	public static void main(String[] args){
		int[][] arr = new int[4][4];

		int i =1;
		for (int col =0 ;col<arr.length;col++){

			for (int row=0;row<arr[col].length;row++) {
				arr[row][col] = i;
				i++;
			}
		}


		printArray(arr);

		System.out.println(matrixcheck(arr,1));
	}

	private static <AnyType> void printArray(int[][] arr){
		for(int col=0;col<arr.length;col++){
			for (int row = 0;row<arr[col].length;row++){
				System.out.print(arr[row][col]+" ");
			}
			System.out.println();
		}
	}
}
