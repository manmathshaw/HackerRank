package test;

import java.util.Arrays;

class GuessANumber extends Thread {
	private int number;
	public GuessANumber(int number) {
		this.number = number;
	}
	public void run() {
		int counter = 0;
		int guess = 0;
		do {
			guess = (int) (Math.random() * 100 + 1);
			System.out.println(this.getName() + " guesses " + guess);
			counter++;
		} while(guess != number);
		System.out.println("** Correct!" + this.getName() + "in" + counter + "guesses.**");
	}
}

public class TripletSum {
	static int countTriplets(int arr[], int sum) {
		int n = arr.length;
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < n - 2; i++) {
			int j = i + 1, k = n - 1;
			while (j < k) {
				if (arr[i] + arr[j] + arr[k] >= sum) {
					k--;
					count++;
				} else {
					j++;
				}
			}
		}
		return count;
	}

	public static String appendDelete(String s, String t, int k) {
		int l1 = s.length();
		int l2 = t.length();
		int minOpCount = 0;
		int length = 0;
		if(l1 > l2) {
			minOpCount = l1 - l2;
			length = l2;
		} else {
			minOpCount = l2 - l1;
			length = l1;
		}
		minOpCount = minOpCount + countOp(s, t, length);
		System.out.println(minOpCount);
		if(minOpCount > k) {
			return "No";
		}
		if((k-minOpCount)%2 != 0 && (minOpCount+length*2 > k)) {
			return "No";
		}
		return "Yes";
	}
	public static int countOp(String s, String t, int length) {
		for(int i=0; i<length; i++) {
			if(s.charAt(i) != t.charAt(i)) {
				return 2*(length - i);
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		
	}
}
