class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][2];

        for (int[][] twoD : dp) {
            for (int[] row : twoD) {
                Arrays.fill(row, -1);
            }
        }

        return helper(prices, 0, 1, 0, dp);
    }

    private int helper(int[] prices, int index, int buy, int maxTransactions, int[][][] dp) {
        if (index == prices.length) {
            return 0;
        }

        if (maxTransactions == 2) {
            return 0;
        }

        if (dp[index][buy][maxTransactions] != -1) {
            return dp[index][buy][maxTransactions];
        }

        int profit = 0;

        if (buy == 1) {
            int profit1 = -prices[index] + helper(prices, index + 1, 0, maxTransactions, dp);
            int profit2 = 0 + helper(prices, index + 1, 1, maxTransactions, dp);
            profit = Math.max(profit1, profit2);
        } else {
            int profit1 = prices[index] + helper(prices, index + 1, 1, maxTransactions + 1, dp);
            int profit2 = 0 + helper(prices, index + 1, 0, maxTransactions, dp);
            profit = Math.max(profit1, profit2);
        }

        return dp[index][buy][maxTransactions] = profit;
    }
}