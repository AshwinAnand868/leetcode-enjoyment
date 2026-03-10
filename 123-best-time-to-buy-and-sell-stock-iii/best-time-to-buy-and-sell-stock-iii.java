class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];
        
        for(int buy = 0; buy <= 1; buy++) {
            for(int transaction = 0; transaction <= 2; transaction++) {
                dp[n][buy][transaction] = 0;
            }
        }

        for(int i = 0; i <= n; ++i) {
            for(int buy = 0; buy <= 1; buy++) {
                dp[i][buy][2] = 0; // when 2 transactions are completed
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int t = 0; t <= 1; ++t) {
                    if(buy == 1) {
                        dp[i][buy][t] = Math.max(-prices[i] + dp[i + 1][0][t], dp[i + 1][1][t]);
                    } else {
                        dp[i][buy][t] = Math.max(prices[i] + dp[i + 1][1][t + 1], dp[i + 1][0][t]);
                    }
                }
            }
        }

        return dp[0][1][0];

        // int[][][] dp = new int[n][2][3];
        // for (int[][] twoD : dp) {
        //     for (int[] row : twoD) {
        //         Arrays.fill(row, -1);
        //     }
        // }

        // return helper(prices, 0, 1, 0, dp);
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