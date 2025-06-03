class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n + 1][m + 1];

        // base case 1 - if t is empty
        for(int i = 0; i <= n; ++i) {
            dp[i][0] = 1; // there is always an empty subsequence
        }

        // base case 2 - if s is empty
        for(int i = 1; i <= m; ++i) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                dp[i][j] += dp[i - 1][j];
            }
        }

        return dp[n][m];

        // for(int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }

        // return helper(s, t, n - 1, m - 1, dp);
    }

    private int helper(String s, String t, int sdx, int tdx, int[][] dp) {
        if(tdx < 0) return 1; // full t string has been matched
        if(sdx < 0) return 0; // s is exhausted, but t didn't match

        int count = 0;

        if(dp[sdx][tdx] != -1) {
            return dp[sdx][tdx];
        }

        if(s.charAt(sdx) == t.charAt(tdx)) {
            count += helper(s, t, sdx - 1, tdx - 1, dp); // including matching character
        }

        count += helper(s, t, sdx - 1, tdx, dp); // skipping character

        return dp[sdx][tdx] = count;
    }
}