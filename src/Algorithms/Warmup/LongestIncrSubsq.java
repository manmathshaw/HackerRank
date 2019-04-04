package practicegeeks;

import java.util.ArrayList;
import java.util.List;

public class LongestIncrSubsq {
	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis1( arr, n ) );
	}

	static int lis(int arr[],int n) {
		int lis[] = new int[n];
		int i,j,max = 0;

		/* Initialize LIS values for all indexes */
		for ( i = 0; i < n; i++ )
			lis[i] = 1;

		/* Compute optimized LIS values in bottom up manner */
		for ( i = 1; i < n; i++ ) {
			for ( j = 0; j < i; j++ ) {
				if (arr[i] > arr[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
			if ( max < lis[i] ) {
				max = lis[i];
			}
		}
		return max;
	}
	static int lis1(int arr[],int n) {
		int lis[] = new int[n];
		int i,j,max = 0;
		List<Integer> tempList = null;
		for ( i = 0; i < n-2; i++ ) {
			tempList = new ArrayList<Integer>();
			tempList.add(arr[i]);
			if(arr[i+1] > tempList.get(i)) {
				tempList.add(arr[i+1]);
			}
			if(arr[i+2] > tempList.get(i+1)) {
				
			}
			if ( max < lis[i] ) {
				max = lis[i];
			}
		}
		return max;
	}
}
