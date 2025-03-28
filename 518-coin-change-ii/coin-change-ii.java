class Solution {

    private int minCoins = Integer.MAX_VALUE;

    public int backtrack(int[] coins, int amount, int index, int[][] dp) {
        if(amount == 0) {
            return 1;
        }

        if(amount < 0 || index >= coins.length) return 0;

        if (dp[index][amount] != -1) return dp[index][amount];

        int ways = 0;
        for(int times = (amount/coins[index]); times >= 0; times--) {
            ways += backtrack(coins, amount - times * coins[index], index + 1, dp);
        }

        dp[index][amount] = ways;
        return ways;
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return backtrack(coins, amount, 0, dp);
    }
}