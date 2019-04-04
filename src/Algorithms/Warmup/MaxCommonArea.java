package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxCommonArea {

	public static void main(String[] args) {
		int[] heightArr = {1,5,2,5};
		System.out.println(maxArea(heightArr));
	}
	private static int maxArea(int[] heightArr) {
		int n = heightArr.length;
	    int minHeight = 0;
	    List<Integer> areaList = new ArrayList<Integer>();
	    int width = 0;
	    for(int i = 0; i < n; i++){
	    		areaList.add(heightArr[i]);
	    		minHeight = heightArr[i];
	    		width = 1;
	        for(int j = i+1; j < n; j++){
	        		width++;
	        		minHeight = minHeight < heightArr[j] ? minHeight : heightArr[j];
	        		areaList.add(minHeight*width);
	        }
	    }
	    //System.out.println(areaList);
	    return Collections.max(areaList);
	}
}
