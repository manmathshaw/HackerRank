package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam {

	public static void main(String args[]) {
		int n;
		Integer i = null;
		n = i;
		System.out.println(n);
		//System.out.println(Long.MAX_VALUE);
		//System.out.println(smallestString(19));
		/*List<List<Integer>> markings = new ArrayList<List<Integer>>();
		List<Integer> requirements = new ArrayList<>();
		requirements.add(4);
		requirements.add(6);
		//requirements.add(6);
		//requirements.add(7);
		List<Integer> marking1 = new ArrayList<>();
		marking1.add(5);
		marking1.add(7);
		marking1.add(10);
		markings.add(marking1);
		List<Integer> marking2 = new ArrayList<>();
		marking2.add(4);
		marking2.add(10);
		markings.add(marking2);
		List<Integer> marking3 = new ArrayList<>();
		marking3.add(3);
		marking3.add(5);
		marking3.add(6);
		markings.add(marking3);
		System.out.println(chooseFlask(requirements, 2, markings));*/
	}
	public static void checkPassageTime(int[] time, int[] status, int n) {
		//getTimes([0, 1, 1, 3,3], [0, 1, 0, 0, 1]);
		boolean exit = true;
		int[] passingTime = new int[n];
		for(int i=0; i<n-1; i++) {
			if(time[i] == time[i+1]) {
				
			} else {
				passingTime[i] = time[i];
			}
		}
		
		
	}

	public static int chooseFlask(List<Integer> requirements, int m, List<List<Integer>> markings) {
		// Write your code here
		int requirement = 0;
		int reqCount = requirements.size();
		Map<Integer, List<Integer>> lossMap = new HashMap<>();
		for(int n = 0; n < m; n++) {
			lossMap.put(n, new ArrayList<Integer>());
		}
		List<Integer> lossList = null;
		List<Integer> flashMarkList = null;
		for (int i = 0; i < reqCount; i++) {
			requirement = requirements.get(i);
			for (int j = 0; j < m; j++) {
				flashMarkList = markings.get(j);
				System.out.println("requirement -> " + requirement);
				if(requirement > flashMarkList.get(flashMarkList.size()-1)) {
					lossList = lossMap.get(j);
					lossList.add(-1);
					break;
				}
				for(int k = 0; k < flashMarkList.size(); k++) {
					System.out.println("flashMarkList.get(k) -> " + flashMarkList.get(k));
					if (requirement <= flashMarkList.get(k)) {
						lossList = lossMap.get(j);
						lossList.add(flashMarkList.get(k) - requirement);
						lossMap.put(j, lossList);
						//lossArr[i] = lossArr[i] + (flashMarkList.get(k) - requirement);
						break;
					}
				}
			}
		}
		int minLoss = Integer.MAX_VALUE;
		int flaskNo = -1;
		int sum = 0;
		for(int n = 0; n < m; n++) {
			if(!lossMap.get(n).contains(-1)) {
				sum = lossMap.get(n).stream().mapToInt(Integer::intValue).sum();
				if(sum < minLoss) {
					minLoss = sum;
					flaskNo = n;
				}
			}
		}
		return flaskNo;
	}

	public static String smallestString(long weight) {
		StringBuffer output = new StringBuffer();
		// Write your code here
		Map<Character, Long> charWeightMap = new HashMap<Character, Long>(26);
		long val = 0;
		int factor = 1;
		// Taken till 'T' because after that it cant be stored as long
		// As the input is in long, it can
		for(char ch1='A'; ch1<='T'; ch1++) {
			val = factor * val + factor;
			charWeightMap.put(ch1, val);
			factor++;
		}
		for(char ch2='T'; ch2>='A'; ch2--) {
			if (weight == 0) {
				break;
			}
			if(weight == charWeightMap.get(ch2)) {
				output.append(ch2);
				break;
			}
			while(weight >= charWeightMap.get(ch2)) {
				weight = weight - charWeightMap.get(ch2);
				output.append(ch2);
			}
		}
		return output.toString();
	}

}
