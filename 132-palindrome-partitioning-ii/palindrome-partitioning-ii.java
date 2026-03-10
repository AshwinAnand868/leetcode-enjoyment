class Solution {

    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private int helper(int i, int n, String str, int[] dp) {
        // Base case:
        if (i == n) return 0;

        if(dp[i] != -1) {
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;
        // String[i...j]
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {
                int cost = 1 + helper(j + 1, n, str, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        // Arrays.fill(dp, -1);
        // return helper(0, n, s, dp) - 1;

        dp[n] = 0; // base case

        for(int i = n - 1; i >= 0; --i) {
            int minCuts = Integer.MAX_VALUE;
            // String[i...j]
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int cuts = 1 + dp[j + 1];
                    minCuts = Math.min(minCuts, cuts);
                }
            }
            dp[i] = minCuts;
        }

        return dp[0] - 1;
    }
}