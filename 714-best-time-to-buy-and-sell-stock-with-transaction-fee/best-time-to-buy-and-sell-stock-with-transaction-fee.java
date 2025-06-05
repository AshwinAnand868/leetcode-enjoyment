class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(prices, 0, 1, fee, dp);
    }

    private int helper(int[] prices, int index, int buy, int fee, int[][] dp) {
        if(index == prices.length) {
            return 0;
        }

        if(dp[index][buy] != -1) {
            return dp[index][buy];
        }

        int profit = 0;

        if (buy == 1) {
            int profit1 = -prices[index] + helper(prices, index + 1, 0, fee, dp);
            int profit2 = helper(prices, index + 1, 1, fee, dp);
            profit = Math.max(profit1, profit2);
        } else {
            int profit1 = prices[index] - fee + helper(prices, index + 1, 1, fee, dp);
            int profit2 = helper(prices, index + 1, 0, fee, dp);
            profit = Math.max(profit1, profit2);
        }

        return dp[index][buy] = profit;
    }
}