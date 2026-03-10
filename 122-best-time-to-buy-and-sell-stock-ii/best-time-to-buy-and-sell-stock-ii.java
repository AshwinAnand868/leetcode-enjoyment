class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0; // if our stock market prices are exhausted

        int profit = 0;

        for(int i = n - 1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                if(buy == 1) {
                    profit = Math.max(-prices[i] + dp[i + 1][0], 0 + dp[i + 1][1]);
                } else {
                    profit = Math.max(prices[i] + dp[i + 1][1], 0 + dp[i + 1][0]);
                }
                dp[i][buy] = profit;
            }
        }

        return dp[0][1];



        // Integer[][] memo = new Integer[n][2];
        // return helper(prices, 0, 1, memo);
    }

    private int helper(int[] prices, int index, int buy, Integer[][] memo) {
        
        if(index == prices.length) {
            return 0; // no profits to be made
        }

        if(memo[index][buy] != null) {
            return memo[index][buy];
        }

        if(buy == 1) { // stock yet to be bought
            // i can either buy it which will result in reduction in our profit
            int profit1 = -prices[index] + helper(prices, index + 1, 0, memo);
            int profit2 = 0 + helper(prices, index + 1, 1, memo); // if I do not buy it
            return memo[index][buy] = Math.max(profit1, profit2);
        } else { // sell case
            // if the stock is already bought, i can either sell it
            int profit1 = prices[index] + helper(prices, index + 1, 1, memo);
            int profit2 = 0 + helper(prices, index + 1, 0, memo);
            return memo[index][buy] = Math.max(profit1, profit2);
        }
    }
}