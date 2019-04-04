package practicegeeks;

public class MinNoCoins {

	public static void main(String[] args) {
		int n = 93;
		findMin(n);
	}
	static void findMin(int sum) {
		int deno[] = {1000, 500, 100, 50, 20, 10, 3, 2, 1};
		int i = 0;
		for(i=0; i<deno.length;) {
			if(sum < deno[i]) {
				i++;
			} else {
				System.out.println(deno[i]);
				sum = sum - deno[i];
			}
			if(sum == 0) {
				break;
			}
		}
	}
}
