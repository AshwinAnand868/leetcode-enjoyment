class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        for (int[] rows : dp)
            Arrays.fill(rows, -1);

        return helper(text1, n - 1, text2, m - 1, dp);
    }

    private int helper(String text1, int ind1, String text2, int ind2, int[][] dp) {
        if(ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];


        if(text1.charAt(ind1) == text2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + helper(text1, ind1 - 1, text2, ind2 - 1, dp);
        }

        return dp[ind1][ind2] = 0 + Math.max(helper(text1, ind1, text2, ind2 - 1, dp), helper(text1, ind1 - 1, text2, ind2, dp));
    }
}