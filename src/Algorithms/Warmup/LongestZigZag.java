package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestZigZag {

	public static void main(String[] args) {
		//long n = 1001;
		//System.out.println(LongestZigZag.count_numbers_factors(12));
		//System.out.println(getNumber("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"));
		//System.out.println(permutationCoeff(10, 9));
		//int gold[][]= { {1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2} };            
		//int m = 4, n = 4; 
		//System.out.print(getMaxGold1D(gold, m, n));
		int a = 61;
		System.out.println("60  = " + Integer.toBinaryString(a));
		int c = a >> 2;              
	    System.out.println( c + " = " + Integer.toBinaryString(c));
	}
	static int permutationCoeff(int n, int k) { 
		int pCoff = 1; 
		for (int i = n-k+1; i <= n; i++) { 
			pCoff *= i;
		} 
		return pCoff; 
	}
	static int getMaxGold1D(int gold[][], int m, int n) { 
		// Create a table for storing intermediate results and initialize all cells to 0. The first row of goldMineTable gives the maximum gold that the miner can collect when starts that row 
		int goldTable[] = new int[n]; 
		for (int col = n-1; col >= 0; col--) { 
			for (int row = 0; row < m; row++) { 
				// Gold collected on going to the cell on the right(->) 
				int right = (col == n-1) ? 0 : goldTable[row]; 
				// Gold collected on going to the cell to right up (/) 
				int right_up = (row == 0 || col == n-1) ? 0 : goldTable[row-1]; 
				// Gold collected on going to the cell to right down (\) 
				int right_down = (row == m-1 || col == n-1) ? 0 : goldTable[row+1]; 
				// Max gold collected from taking either of the above 3 paths 
				goldTable[row] = gold[row][col] + Math.max(right, Math.max(right_up, right_down)); 
			}
		} 
		int res = goldTable[0]; 
		for (int i = 1; i < n; i++) {
			//System.out.println(goldTable[i]);
			res = Math.max(res, goldTable[i]); 
		}
		return res;
	}
	static int getMaxGold(int gold[][], int m, int n) { 
		// Create a table for storing intermediate results and initialize all cells to 0. The first row of goldMineTable gives the maximum gold that the miner can collect when starts that row 
		int goldTable[][] = new int[m][n]; 
		for(int[] rows:goldTable) 
			Arrays.fill(rows, 0); 
		for (int col = n-1; col >= 0; col--) { 
			for (int row = 0; row < m; row++) { 
				// Gold collected on going to the cell on the right(->) 
				int right = (col == n-1) ? 0 : goldTable[row][col+1]; 
				// Gold collected on going to the cell to right up (/) 
				int right_up = (row == 0 || col == n-1) ? 0 : goldTable[row-1][col+1]; 
				// Gold collected on going to the cell to right down (\) 
				int right_down = (row == m-1 || col == n-1) ? 0 : goldTable[row+1][col+1]; 
				// Max gold collected from taking either of the above 3 paths 
				goldTable[row][col] = gold[row][col] + Math.max(right, Math.max(right_up, right_down)); 
			} 
		} 
		int res = goldTable[0][0]; 
		for (int i = 1; i < m; i++) 
			res = Math.max(res, goldTable[i][0]); 
		return res;
	}
	public static void longestZigZag() {
		int[] input = new int[] { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
		List<Integer> outputList = new ArrayList<>();
		boolean up = true;
		int compareSmall = input[1];
		int compareLarge = input[1];
		if(input[0] > input[1]) {
			up = false;
		}
		outputList.add(input[0]);
		outputList.add(input[1]);

		for(int i=1; i<input.length-1; i++) {
			if(up) {
				if(compareLarge > input[i+1]) {
					outputList.add(input[i+1]);
					compareSmall = input[i+1];
					up = false;
				} else {
					outputList.remove(outputList.size() - 1);
					outputList.add(input[i+1]);
					compareLarge = input[i+1];
				}
			} else {
				if(compareSmall < input[i+1]) {
					outputList.add(input[i+1]);
					compareLarge = input[i+1];
					up = true;
				} else {
					outputList.remove(outputList.size() - 1);
					outputList.add(input[i+1]);
					compareSmall = input[i+1];
				}
			}
		}
		System.out.println(outputList);
		System.out.println(outputList.size());
	}
	public static boolean is_numeric_palindrome(long number) {
		if(number < 10) {
			return true;
		}
		char[] numChars = String.valueOf(number).toCharArray();
		int len = numChars.length;
		for(int i=0; i<len/2; i++) {
			if(numChars[i] != numChars[len-i-1]) {
				return false;
			}
		}
		return true;
	}
	public static int count_numbers_factors(long number) {
		// Write your code here   
		long sqrt = (long)Math.sqrt(number);
		System.out.println(sqrt);
		int count = 2;
		for(int i=2; i<=sqrt; i++) {
			if(number%i == 0) {
				count = count + 2;
			}
		}
		if(sqrt*sqrt == number) {
			count--;
		}
		return count;
	}
	public static int getNumber(String input) {
		//RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR
		int n = input.length();
		int maxCount = 1;
		int tempCount = 1;
		if(n==1) {
			return 0;
		}
		for(int i=0; i<n-1; i++) {
			if(input.charAt(i) == input.charAt(i+1)) {
				tempCount++;
			} else {
				if(tempCount > maxCount) {
					maxCount = tempCount;
				}
				tempCount = 1;
			}
		}
		if(tempCount > maxCount) {
			maxCount = tempCount;
		}
		return (n-maxCount);
	}
}
