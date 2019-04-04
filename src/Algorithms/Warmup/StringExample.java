package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringExample {
	public static void main(String[]args) throws IOException {
		/*BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		String str4 = "ab";
		str4 = str4+"c";
		String str5 = bufferRead.readLine();
		String str6 = new String("abc");
		System.out.println(str1 == "abc");	//true
		System.out.println(str1 == str2);	//true
		System.out.println(str1 == str3);	//false
		System.out.println(str1 == str4);	//false
		System.out.println(str1 == str5);	//false
		System.out.println(str3 == str6);	//false
		str6.intern();
		System.out.println(str1 == str6);	//false
		str6 = str6.intern();
		System.out.println(str1 == str6);	//true*/
		int[] input = {1,2 ,5, 3, 7, 8, 6, 4};
		StringExample.findChaotic(input);
	}

	public static void findChaotic(int[] q) {
		int bribes = 0, temp, diff;
		boolean isChaotic = false;
		// checking for chaotic first because in vase chaotic, it will be solved in O(n)
		for(int i=0; i<q.length; i++) {
			if(q[i] - (i+1) > 2) {
				isChaotic = true;
				break;
			}
		}
		if(isChaotic) {
			System.out.println("Too chaotic");
		} else {
			for(int i=1; i<q.length; i++) {
				for(int j=i; j>0; j--) {
					diff = q[j] - q[j-1];
					if(diff == 1 ) {
						break;
					} else if(diff < 1) {
						temp = q[j];
						q[j] = q[j-1];
						q[j-1] = temp;
						bribes++;
					}
				}
			}
			System.out.println(bribes);
		}
	}
}
