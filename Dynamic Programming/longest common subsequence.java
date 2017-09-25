// Find the length of the longest common subsequence of two given strings
class Main {
    int lcs(char[] X, char[] Y, int m, int n){
        int[][] L = new int[m+1][n+1];
        int i = 0, j = 0;

        for(i = 0; i <= m; i++){
            for(j = 0; j <= n; j++){
                if(i == 0 || j == 0)
                    L[i][j] = 0;
                else if(X[i-1] == Y[j-1])
                    L[i][j] = 1 + L[i-1][j-1];
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[i-1][j-1]; // return last element of the table
    }

	public static void main (String[] args) {
	    // input
	    String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	    int m = s1.length();
	    int n = s2.length();

	    char[] X = s1.toCharArray();
	    char[] Y = s2.toCharArray();

	    System.out.println("Longest Common Subsequence: " + new Main().lcs(X, Y, m, n));
	}
}
