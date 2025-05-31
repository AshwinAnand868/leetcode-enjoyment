class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // ✅ Base Case I: When amount = 0
        for (int c = 0; c <= n; ++c) {
            dp[c][0] = 1;  // 1 way to make amount 0
        }

        // ✅ Base Case II: Only using the first coin
        for (int a = 0; a <= amount; ++a) {
            if (a % coins[0] == 0) {
                dp[1][a] = 1;  // Only one way to make amount 'a' using coins[0]
            } else {
                dp[1][a] = 0;
            }
        }

        // ✅ Fill DP table
        for (int c = 2; c <= n; ++c) {
            for (int a = 1; a <= amount; ++a) {
                int notPick = dp[c - 1][a];
                int pick = 0;

                if (coins[c - 1] <= a) {
                    pick = dp[c][a - coins[c - 1]];
                }

                dp[c][a] = pick + notPick;
            }
        }

        return dp[n][amount];
    }
}
