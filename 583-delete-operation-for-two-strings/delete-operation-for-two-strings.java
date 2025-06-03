class Solution {
    public int minDistance(String s1, String s2) {
        int lcsAnswer = lcs(s1, s2);
        int extraCharsS1 = s1.length() - lcsAnswer;
        int extraCharsS2 = s2.length() - lcsAnswer;
        
        return extraCharsS1 + extraCharsS2;
    }
    
    public int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        
        int[][] dp = new int[n + 1][m + 1]; // as the base case is for i < 0 we shift the indices to accomodate the 0 length

        for(int i = 0; i <= n; ++i) {
            dp[i][0] = 0;
        }

        for(int i = 0; i <= m; ++i) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // if both chars are equal, shrink the strings
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n][m];

        // int[][] memo = new int[n][m];
        
        // for(int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }
        
        // return helper(s1, s2, n - 1, m - 1, memo);
    }
    
    private int helper(String s1, String s2, int i1, int i2, int[][] memo) {
        if(i1 < 0 || i2 < 0) {
            return 0;
        }
        
        if(memo[i1][i2] != -1) {
            return memo[i1][i2];
        }
        
        if(s1.charAt(i1) == s2.charAt(i2)) {
            // if both chars are equal, shrink the strings
            return memo[i1][i2] = 1 + helper(s1, s2, i1 - 1, i2 - 1, memo);
        } else {
            return memo[i1][i2] = Math.max(helper(s1, s2, i1 - 1, i2, memo),
                helper(s1, s2, i1, i2 - 1, memo));
        }
    }
}