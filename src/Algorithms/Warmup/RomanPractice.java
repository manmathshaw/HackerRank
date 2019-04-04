package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanPractice {

	public static void main(String[] args) {
		RomanPractice obj = new RomanPractice();
		int num = obj.convertRomanToNum("VXII");
		if(num == 0) {
			System.out.println("Not a valid Roman number");
		} else {
			System.out.println(num);
		}
		System.out.println(obj.convertNumToRoman(9826));
	}
	
	private int convertRomanToNum(String romanNum) {
		int num = 0;
		List<String> invalidCases = Arrays.asList(new String[] {"IL","IC","ID","IM","VX","VL","VC","VD","XD","XM","LC","LD","LM","DM"});
		Map<String, Integer> romanValMap = new HashMap<>();
		romanValMap.put("I", 1);
		romanValMap.put("V", 5);
		romanValMap.put("X", 10);
		romanValMap.put("L", 50);
		romanValMap.put("C", 100);
		romanValMap.put("D", 500);
		romanValMap.put("M", 1000);
		romanValMap.put("IV", 4);
		romanValMap.put("IX", 9);
		romanValMap.put("XL", 40);
		romanValMap.put("XC", 90);
		romanValMap.put("CD", 400);
		romanValMap.put("CM", 900);
		char[] romanCharArr = romanNum.toCharArray();
		int i = 0;
		while(i<romanCharArr.length-1) {
			String twoDigitVal = Character.toString(romanCharArr[i]) + Character.toString(romanCharArr[i+1]);
			if(invalidCases.contains(twoDigitVal)) {
				return 0;
			}
			if(romanValMap.containsKey(twoDigitVal)) {
				num = num + romanValMap.get(twoDigitVal);
				i++;
				i++;
				continue;
			}
			String oneDigitVal = Character.toString(romanCharArr[i]);
			if(romanValMap.containsKey(oneDigitVal)) {
				num = num + romanValMap.get(oneDigitVal);
				i++;
			} else {
				return 0;
			}
		}
		if(i == romanCharArr.length-1) {
			String lastDigitVal = Character.toString(romanCharArr[i]);
			if(romanValMap.containsKey(lastDigitVal)) {
				num = num + romanValMap.get(Character.toString(romanCharArr[i]));
			} else {
				return 0;
			}
		}
		return num;
	}
	private String convertNumToRoman(int number) {
		String romanVal = "";
		int[] posblVals = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; 
		String[] posblRomans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; 
		int posDiviser = 0;
		int count = 0;
		while(number > 0) {
			count = number/posblVals[posDiviser];
			if(count > 0) {
				number = number - count * posblVals[posDiviser];
				for(int n=0; n<count; n++) {
					romanVal = romanVal + posblRomans[posDiviser];
				}
			} else {
				posDiviser++;
			}
		}
		return romanVal;
	}
}
