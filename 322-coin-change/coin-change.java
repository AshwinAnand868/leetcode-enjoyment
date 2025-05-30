class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Initialize dp with -1 (uncomputed)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = helper(coins, amount, n - 1, dp);
        return ans >= (int)1e9 ? -1 : ans;
    }

    public int helper(int[] coins, int amount, int index, int[][] dp) {
        if (amount == 0) return 0;
        if (index < 0) return (int)1e9;

        if (dp[index][amount] != -1) return dp[index][amount];

        int nonPick = helper(coins, amount, index - 1, dp);
        int pick = (int)1e9;

        if (coins[index] <= amount) {
            pick = 1 + helper(coins, amount - coins[index], index, dp);
        }

        dp[index][amount] = Math.min(pick, nonPick);
        return dp[index][amount];
    }
}
