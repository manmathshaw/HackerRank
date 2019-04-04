package practicegeeks;

public class MaxSumSubArray {
	static int maxSubArraySum(int a[], int size) {
		int max_sum = a[0];
		int start = 0, end = 0;
		for (int i = 1; i < size; i++) {
			if(a[i-1]+a[i] > a[i]) {
				a[i] = a[i-1]+a[i];
			} else {
				start = i;
			}
			if(max_sum < a[i]) {
				max_sum = a[i];
				end = i;
			}
		}
		System.out.println("The start index is " + start + " and the end index is " + end);
		return max_sum;
	}

	public static void main(String[] args) {
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int n = a.length;   
		int max_sum = maxSubArraySum(a, n);
		System.out.println("Maximum contiguous sum is " + max_sum);
	}
}
