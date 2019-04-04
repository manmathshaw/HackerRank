package practicegeeks;

import java.util.HashMap;
import java.util.Map;

public class SumBase14 {
	static String sumBase14(String num1,  String num2) {
		int l1 = num1.length();
		int l2 = num2.length();
		Map<Integer, Character> numMap = new HashMap<Integer, Character>();
		numMap.put(0, '0');
		numMap.put(1, '1');
		numMap.put(2, '2');
		numMap.put(3, '3');
		numMap.put(4, '4');
		numMap.put(5, '5');
		numMap.put(6, '6');
		numMap.put(7, '7');
		numMap.put(8, '8');
		numMap.put(9, '9');
		numMap.put(10, 'A');
		numMap.put(11, 'B');
		numMap.put(12, 'C');
		numMap.put(13, 'D');
		StringBuffer temp = null;
		if(l1 > l2) {
			temp = new StringBuffer();
			while(l1>l2) {
				temp.append("0");
				l1--;
			}		
			num2 = temp.append(num2).toString();
			l2 = l1;
		} else if(l2 > l1) {
			temp = new StringBuffer();
			while(l2>l1) {
				temp.append("0");
				l2--;
			}
			num1 = temp.append(num1).toString();
			l1 = l2;
		}
		StringBuffer resultBuffer = new StringBuffer();
		int carry = 0, sumOfDigits = 0;
		for(int i=l1-1; i>0; i--) {
			sumOfDigits = carry + sumOfDigits(num1.charAt(i), num2.charAt(i));
			if(sumOfDigits > 13) {
				carry = 1;
				sumOfDigits = sumOfDigits - 14;
			} else {
				carry = 0;
			}
			resultBuffer.append(numMap.get(sumOfDigits));
		}
		if(carry == 1) {
			resultBuffer.append(carry);
		}
		return resultBuffer.reverse().toString();
	
	}
	static int sumOfDigits(char c1, char c2) {
		int sum = 0;
		if(c1 > '0' && c1 < '9') {
			
		}
		
		return sum;
	}
	
	public static void main(String args[]) {
		String num1 = "DC2";
	    String num2 = "0A3";
		System.out.println(sumBase14(num1, num2));
	}
}
