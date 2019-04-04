package practicegeeks;

import java.util.Arrays;
import java.util.Comparator;

class Job {
	char id;
	int deadLine;
	int profit;
	
	Job(char id, int deadLine, int profit) {
		this.id = id;
		this.deadLine = deadLine;
		this.profit = profit;
	}
	
	public String toString() {
		return "id :: " + this.id + " :: deadLine :: " + deadLine + " :: profit :: " + profit;
	}
}
class ComparatorJob implements Comparator<Job> {
	@Override
	public int compare(Job x, Job y) {
		return y.profit - x.profit;
	}
}
public class JobSequencing {

	public static void main(String[] args) {
		//Job[] jobArr = {new Job('a', 2, 100), new Job('b', 1, 19), new Job('c', 2, 27), new Job('d', 1, 25), new Job('e', 3, 15)};
		Job[] jobArr = {new Job('a', 4, 20), new Job('b', 1, 10), new Job('c', 1, 40), new Job('d', 1, 30)};
		int n = jobArr.length;
		printJobScheduling(jobArr, n);
	}
	
	static void printJobScheduling(Job[] arr, int n) {
		
		Arrays.sort(arr, new ComparatorJob());
		int deadLine = 0;
		char[] charSeqArr = new char[n];
		for(int i=0; i<n; i++) {
			deadLine = arr[i].deadLine;
			while(deadLine > 0) {
				if(charSeqArr[deadLine-1] == '\u0000') {
					charSeqArr[deadLine-1] = arr[i].id;
					break;
				}
				deadLine--;
			}
		}
		for(int j=0; j<n; j++) {
			System.out.println(charSeqArr[j]);
		}
	}
}
