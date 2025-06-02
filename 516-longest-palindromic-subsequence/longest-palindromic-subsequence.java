class Solution {
    public int longestPalindromeSubseq(String s) {
        // return lps(s, 0, s.length() - 1);
        String reversed = new StringBuilder(s).reverse().toString();
        return lcs(s, reversed);
    }

    private int lcs(String s, String reversed) {
        int n = s.length();
        int m = reversed.length();

        int[][] dp = new int[n + 1][m + 1];

        // base cases are for length 0 dp[i][0] = 0 or dp[0][j] = 0

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                if(s.charAt(i - 1) == reversed.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // shrink both strings
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // shrink one and the other
                }
            }
        }

        return dp[n][m];
    }

    // private int lps(String s, int i, int j) {
    //     if(i > j) return 0;
    //     if(i == j) return 1;

    //     if(s.charAt(i) == s.charAt(j)) { // 2 chars are equal
    //         return 2 + lps(s, i + 1, j - 1);
    //     } else {
    //         return Math.max(lps(s, i, j - 1), lps(s, i + 1, j));
    //     }
    // }
}