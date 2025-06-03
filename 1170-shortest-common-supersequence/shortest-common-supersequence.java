class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
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

        // int lenLCS = dp[n][m];
        int i = n;
        int j = m;

        StringBuilder ansRev = new StringBuilder();

        while(i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ansRev.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if(dp[i - 1][j] > dp[i][j - 1]) {
                ansRev.append(s1.charAt(i - 1)); // as we are moving to the top, we append s1 char
                i--;
            } else {
                ansRev.append(s2.charAt(j - 1)); // as we are moving to the left, we append s2 char
                j--;
            }
        }

        // process leftover chars for both strings
        while(i > 0) {
            ansRev.append(s1.charAt(i - 1)); // as we are moving to the top, we append s1 char
            i--;
        }

        while(j > 0) {
            ansRev.append(s2.charAt(j - 1)); // as we are moving to the left, we append s2 char
            j--;
        }

        return ansRev.reverse().toString();
    }
}