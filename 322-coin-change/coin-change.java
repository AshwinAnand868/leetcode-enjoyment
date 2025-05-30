class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for(int a = 0; a <= amount; ++a) {
            if (a % coins[0] == 0) {
                dp[0][a] = a / coins[0];
            } else {
                dp[0][a] = (int) 1e9;
            }
        }

        for(int i = 1; i < n; ++i) {
            for(int a = 0; a <= amount; a++) {
                int nonPick = dp[i - 1][a];
                int pick = (int) 1e9;

                if(coins[i] <= a) {
                    pick = 1 + dp[i][a - coins[i]];
                }

                dp[i][a] = Math.min(nonPick, pick);
            }
        }

        return dp[n - 1][amount] >= (int) 1e9 ? -1 : dp[n - 1][amount];
    }
}