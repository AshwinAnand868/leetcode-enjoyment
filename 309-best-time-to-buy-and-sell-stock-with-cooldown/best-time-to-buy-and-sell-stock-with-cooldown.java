class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // Initialize dp array with -1 to indicate uncomputed states
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return helper(prices, 0, 1, dp);
    }

    private int helper(int[] prices, int index, int buy, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        int profit;

        if (buy == 1) {
            int profit1 = -prices[index] + helper(prices, index + 1, 0, dp);
            int profit2 = helper(prices, index + 1, 1, dp);
            profit = Math.max(profit1, profit2);
        } else {
            int profit1 = prices[index] + helper(prices, index + 2, 1, dp); // cooldown
            int profit2 = helper(prices, index + 1, 0, dp);
            profit = Math.max(profit1, profit2);
        }

        dp[index][buy] = profit;
        return profit;
    }
}
