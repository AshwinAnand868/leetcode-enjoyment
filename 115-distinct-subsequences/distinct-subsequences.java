class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n][m];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(s, t, n - 1, m - 1, dp);
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