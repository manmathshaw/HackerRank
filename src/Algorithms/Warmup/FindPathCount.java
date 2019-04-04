package test;

public class FindPathCount {
	static int count = 0;
	static int test = 0;
	public static void main(String[] args) {
		int input[][] = { { 0, 0, 0, -1, 0 }, 
			                { -1, 0, 0, -1, -1 }, 
			                { 0, 0, 0, -1, 0 }, 
			                { -1, 0, -1, 0, -1 }, 
			                { 0, 0, -1, 0, 0 } };
		//int input[][] = { { 0, 0 }, { 0, 0 }};
		//int input[][] = { { 0, 0, -1 }, { -1, 0, 0 }, { 0, 0, 0 }};
		findPathNum(input);
		System.out.println(count);
	}
	private static int findPathNum(int input[][]) {
		countPath(input, 0, 0);
		return count;
		
	}
	private static void countPath(int input[][], int i, int j) {
		if(j+1 == input.length && i+1 == input[0].length) {
			count++;
			return;
		}
		if(j+1<input.length && input[i][j+1] != -1) {
			countPath(input, i, j+1);
		}
		if(i+1<input[0].length && input[i+1][j] != -1) {
			countPath(input, i+1, j);
		}
	}
}
