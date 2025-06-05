class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][k + 1]; // third dim is k + 1 to handle maxTransactions = k
        
        for(int buy = 0; buy <= 1; buy++) {
            for(int transaction = 0; transaction < k; transaction++) {
                dp[n][buy][transaction] = 0;
            }
        }

        for(int i = 0; i <= n; ++i) {
            for(int buy = 0; buy <= 1; buy++) {
                dp[i][buy][k] = 0; // when 2 transactions are completed
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int t = 0; t < k; ++t) {
                    if(buy == 1) {
                        dp[i][buy][t] = Math.max(-prices[i] + dp[i + 1][0][t], dp[i + 1][1][t]);
                    } else {
                        dp[i][buy][t] = Math.max(prices[i] + dp[i + 1][1][t + 1], dp[i + 1][0][t]);
                    }
                }
            }
        }

        return dp[0][1][0];

        // for (int[][] twoD : dp) {
        //     for (int[] row : twoD) {
        //         Arrays.fill(row, -1);
        //     }
        // }

        // return helper(prices, 0, 1, 0, k, dp);
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
