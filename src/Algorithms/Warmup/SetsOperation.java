package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetsOperation {
	public static void main(String[] argv) {
		Set<Integer> set1 = new HashSet<Integer>(); 
		set1.add(2); 
		set1.add(4); 
		set1.add(5);
		Set<Integer> set2 = new HashSet<Integer>(); 
		set2.add(1); 
		set2.add(3); 
		set2.add(5);
		//set1.addAll(set2);
		//set1.removeAll(set2);
		set1.retainAll(set2);
		System.out.println(set1);
		// Use of Iterator
		Iterator<Integer> setIt1 = set1.iterator();
		while(setIt1.hasNext()) {
			System.out.println(setIt1.next());
		}
	}
}
