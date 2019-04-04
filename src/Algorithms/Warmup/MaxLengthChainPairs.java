package practicegeeks;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainPairs {
	public static void main(String[] args) 
    {
        Pair arr[] = new Pair[] {new Pair(5,24), new Pair(15, 28), new Pair(50, 90), new Pair (27, 40), new Pair (39, 60)};
        System.out.println("Length of maximum size chain is " + 
                                  maxChainLength(arr, arr.length));
    }
	
	static int maxChainLength(Pair arr[], int n) {
		Arrays.sort(arr, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.a - p2.a;
			}
		});
		int[] maxLen = new int[n];
		for(int j=0; j<n; j++) {
			maxLen[j] = 1;
		}
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i].a > arr[j].b && maxLen[i] < maxLen[j] + 1) {
					maxLen[i] = maxLen[j] + 1;
				}
			}
		}
		return maxLen[n-1];
    }

}

class Pair{
    int a;
    int b;
     
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}