class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][k + 1]; // third dim is k + 1 to handle maxTransactions = k

        for (int[][] twoD : dp) {
            for (int[] row : twoD) {
                Arrays.fill(row, -1);
            }
        }

        return helper(prices, 0, 1, 0, k, dp);
    }

    private int helper(int[] prices, int index, int buy, int maxTransactions, int k, int[][][] dp) {
        if (index == prices.length || maxTransactions == k) {
            return 0;
        }

        if (dp[index][buy][maxTransactions] != -1) {
            return dp[index][buy][maxTransactions];
        }

        int profit;
        if (buy == 1) {
            int buyStock = -prices[index] + helper(prices, index + 1, 0, maxTransactions, k, dp);
            int skip = helper(prices, index + 1, 1, maxTransactions, k, dp);
            profit = Math.max(buyStock, skip);
        } else {
            int sellStock = prices[index] + helper(prices, index + 1, 1, maxTransactions + 1, k, dp);
            int skip = helper(prices, index + 1, 0, maxTransactions, k, dp);
            profit = Math.max(sellStock, skip);
        }

        return dp[index][buy][maxTransactions] = profit;
    }
}
