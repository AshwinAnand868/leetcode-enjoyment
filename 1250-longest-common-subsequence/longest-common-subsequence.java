class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // int[][] dp = new int[n + 1][m + 1]; // we are indicing based on the length of the string and storing the length of the common subseq as the value i.e. dp[i][j] = val

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        // if the first string length is 0, then we can't make any common subsequence,
        // similar if second string length is 0

        // looping through from string lengths 1
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = 0 + Math.max(curr[j - 1], prev[j]);
                }
            }

            prev = (int[]) curr.clone();
        }

        return prev[m];
        

        // for (int[] rows : dp)
        //     Arrays.fill(rows, -1);

        // return helper(text1, n - 1, text2, m - 1, dp);
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