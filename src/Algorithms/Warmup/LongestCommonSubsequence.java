package practicegeeks;

public class LongestCommonSubsequence {
	int lcs( char[] X, char[] Y, int m, int n ) {
		int L[][] = new int[m+1][n+1];
		StringBuffer sb = new StringBuffer();
		/* Following steps build L[m+1][n+1] in bottom up fashion. Note
	         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
		for (int i=0; i<=m; i++) {
			for (int j=0; j<=n; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				} else if (X[i-1] == Y[j-1]) {
					L[i][j] = L[i-1][j-1] + 1;
				} else {
					L[i][j] = max(L[i-1][j], L[i][j-1]);
				}
			}
		}
		//Print string
		int i=m;
		int j=n;
		while(i>0 && j>0) {
			if(L[i-1][j] != L[i][j] && L[i][j-1] != L[i][j]) {
				sb.append(X[i-1]);
				i--; j--;
			} else if(L[i-1][j] == L[i][j]) {
				i--;
			} else {
				j--;
			}
		}
		System.out.println("Longest Common Subsequence is : " + sb.reverse().toString());
		return L[m][n];
	}

	/* Utility function to get max of 2 integers */
	int max(int a, int b) {
		return (a > b)? a : b;
	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X=s1.toCharArray();
		char[] Y=s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " +
				lcs.lcs( X, Y, m, n ) );
	}
}
