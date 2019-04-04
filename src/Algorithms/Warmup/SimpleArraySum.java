package Algorithms.Warmup;

import java.util.Scanner;

/**
 * @author manmathshaw
 * https://www.hackerrank.com/challenges/simple-array-sum
Sample Input
6
1 2 3 4 10 11
Sample Output
31
 */

public class SimpleArraySum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int result = 0;
		for(int arr_i=0; arr_i < n; arr_i++){
			result = result + in.nextInt();
		}
		System.out.print(result);
	}
}
