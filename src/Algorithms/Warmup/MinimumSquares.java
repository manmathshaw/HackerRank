package practicegeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumSquares {
	static int getMinSquares(int n)
	{
		// base cases
		if (n <= 3)
			return n;

		// getMinSquares rest of the table using recursive
		// formula
		int res = n; // Maximum squares required is
		// n (1*1 + 1*1 + ..)

		// Go through all smaller numbers
		// to recursively find minimum
		for (int x = 2; x <= n; x++)
		{
			int temp = x*x;
			if (temp > n)
				break;
			else
				res =  Math.min(res, 1+getMinSquares(n - temp));
		}
		return res;
	}
	static int getMinSquaresDyna(int n)
    {
        // Create a dynamic programming table
        // to store sq
        int dp[] = new int[n+1];
      
        // getMinSquares table for base case entries
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
      
        // getMinSquares rest of the table using recursive
        // formula
        for (int i = 4; i <= n; i++)
        {
            // max value is i as i can always be represented
            // as 1*1 + 1*1 + ...
            dp[i] = i;
      
            // Go through all smaller numbers to
            // to recursively find minimum
            for (int x = 1; x <= i; x++) {
                int temp = x*x;
                if (temp > i)
                    break;
                else dp[i] = Math.min(dp[i], 1+dp[i-temp]);
            }
        }
      
        // Store result and free dp[]
        int res = dp[n];
      
        return res;
    }
	static Map<Integer, List<Integer>> getMinSquaresDynaWithVal(int n)
    {
        // Create a dynamic programming table
        // to store sq
		Map<Integer, List<Integer>> valMap = new HashMap<Integer, List<Integer>>();
        int dp[] = new int[n+1];
        // getMinSquares table for base case entries
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
      
        // getMinSquares rest of the table using recursive
        // formula
        for (int i = 4; i <= n; i++)
        {
        		List<Integer> valList = new ArrayList<Integer>();
            // max value is i as i can always be represented
            // as 1*1 + 1*1 + ...
            dp[i] = i;
      
            // Go through all smaller numbers to
            // to recursively find minimum
            for (int x = 2; x <= i; x++) {
                int temp = x*x;
                if (temp > i) {
                    break;
                } else {
                		dp[i] = Math.min(dp[i], 1+dp[i-temp]);
                		valList.add(x);
                }
            }
            valMap.put(dp[i], valList);
        }
      
        // Store result and free dp[]
        //int res = dp[n];
        System.out.println(valMap.size());
        return valMap;
    }
	public static void main(String args[]) {
		System.out.println(getMinSquaresDyna(6));
		System.out.println(getMinSquaresDynaWithVal(8).get(1));
	}
}
