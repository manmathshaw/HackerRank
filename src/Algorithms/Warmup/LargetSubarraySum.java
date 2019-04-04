package practicegeeks;

public class LargetSubarraySum {
	public static void main (String[] args) {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
        
    }
 
    static int maxSubArraySum(int a[]) {
        int size = a.length;
        int sum = a[0], i;
        for(i=1; i<size; i++) {
        		if(a[i] < a[i] + a[i-1]) {
        			a[i] = a[i] + a[i-1];
        		}
        		if(a[i] > sum) {
        			sum = a[i];
        		}
        }
        
        return sum;
    }
}
