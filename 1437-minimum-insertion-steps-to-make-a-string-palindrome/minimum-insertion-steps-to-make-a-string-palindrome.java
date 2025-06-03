class Solution {
    public int minInsertions(String s) {
        // FYI: if we we are asked to find maximum insertions, then we can 
        // append the reverse of the string with itself and the length
        // of the string will be our answer

        // Now for this question, our first goal would be to keep the longest
        // palindromic string intact. The minimum insertions to make it palindrome
        // would be to add the remaining non palindrome strings resulting in our
        // answer as n (string length) - longest palindromic subseq length

        return s.length() - lps(s);
    }

    private int lps(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(s, 0, s.length() - 1, memo);
    }

    private int helper(String s, int i, int j, int[][] memo) {
        if(i > j) return 0;
        if(i == j) return 1;// a single character is a palindrome

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        if(s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = 2 + helper(s, i + 1, j - 1, memo);
        } else {
            return memo[i][j] = 0 + Math.max(helper(s, i, j - 1, memo), helper(s, i + 1, j, memo));
        }
    }
}