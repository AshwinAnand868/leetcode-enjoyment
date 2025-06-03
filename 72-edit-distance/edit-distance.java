class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; ++i) {
            dp[i][0] = i;
        }

        for(int j = 0; j <= m; ++j) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 0 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }

        return dp[n][m];

        // for (int row[] : dp)
        //     Arrays.fill(row, -1);

        // return helper(word1, word2, n - 1, m - 1, dp);
    }

    private int helper(String word1, String word2, int i, int j, int[][] dp) {
        if(i < 0) {
            return j + 1; // insert j + 1 characters
        }

        if(j < 0) {
            return i + 1; // delete i + 1 characters
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = 0 + helper(word1, word2, i - 1, j - 1, dp); // no operation needed as the characters are already matched
        } else {
            /*
                // Minimum of three choices:
                // 1. Replace the character in S1 with the character in S2.
                // 2. Delete the character in S1.
                // 3. Insert the character from S2 into S1.
            */
            return dp[i][j] = 1 + Math.min(helper(word1, word2, i, j - 1, dp), Math.min(helper(word1, word2, i - 1, j, dp), helper(word1, word2, i - 1, j - 1, dp)));
        }
    }
}