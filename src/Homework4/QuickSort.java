package Homework4;

public class QuickSort {
	private static final int CUTOFF = 10;

	public static <AnyType extends Comparable<? super AnyType>> void quicksort( AnyType [ ] a ){
		quicksort( a, 0, a.length - 1 );
	}

	private static <AnyType extends Comparable<? super AnyType>> void quicksort( AnyType [ ] a, int left, int right ){
		if( left + CUTOFF <= right )
		{
			AnyType pivot = a[(left+right) / 2];

			// Begin partitioning
			int i = left, j = right - 1;
			for( ; ; )
			{
				while( a[ ++i ].compareTo( pivot ) < 0 ) { }
				while( a[ --j ].compareTo( pivot ) > 0 ) { }
				if( i < j )
					swapReferences( a, i, j );
				else
					break;
			}

			swapReferences( a, i, right - 1 );   // Restore pivot

			quicksort( a, left, i - 1 );    // Sort small elements
			quicksort( a, i + 1, right );   // Sort large elements
		}
		else { // Do an insertion sort on the subarray
			for (int p = left + 1; p <= right; p++) {
				AnyType tmp = a[p];
				int j;

				for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--)
					a[j] = a[j - 1];
				a[j] = tmp;
			}
		}
	}

	private static <AnyType extends Comparable<? super AnyType>> AnyType median3( AnyType [ ] a, int left, int right ){
		int center = ( left + right ) / 2;
		if( a[ center ].compareTo( a[ left ] ) < 0 )
			swapReferences( a, left, center );
		if( a[ right ].compareTo( a[ left ] ) < 0 )
			swapReferences( a, left, right );
		if( a[ right ].compareTo( a[ center ] ) < 0 )
			swapReferences( a, center, right );

		// Place pivot at position right - 1
		swapReferences( a, center, right - 1 );
		return a[ right - 1 ];
	}

	private static <AnyType extends Comparable<? super AnyType>> AnyType median5( AnyType [ ] a, int left, int right ){
		int center = ( left + right ) / 2;
		int mLeft = (left + center) / 2;
		int mRight = (center + right) / 2;

		if (a[center].compareTo(a[mLeft]) < 0 )
			swapReferences(a,mLeft, center);
		if( a[ center ].compareTo( a[ left ] ) < 0 )
			swapReferences( a, left, center );
		if (a[mRight].compareTo(a[left]) < 0)
			swapReferences(a,left, mRight);
		if( a[ right ].compareTo( a[ left ] ) < 0 )
			swapReferences( a, left, right );
		if( a[ right ].compareTo( a[ center ] ) < 0 )
			swapReferences( a, center, right );


		swapReferences( a, center, right - 1 );
		return a[right-1];
	}

	public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
	{
		AnyType tmp = a[ index1 ];
		a[ index1 ] = a[ index2 ];
		a[ index2 ] = tmp;
	}


	public static void main(String[] args){
		Integer[] a = new Integer[10];
		for (int i =0;i<10;i++){
			a[i] = (int)(Math.random()*1000);
		}

		//printArray(a);
		quicksort(a);
		printArray(a);
	}

	private static<AnyType> void printArray(AnyType[] list){
		for(AnyType item:list){
			System.out.print(item + " ");
		}
		System.out.println();
	}
}
