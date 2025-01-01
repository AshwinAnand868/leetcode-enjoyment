class Solution {
    public int maxProfit(int[] prices) {

        int profit, maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; ++i) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }

            profit = prices[i] - minPrice;

            if(profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;

        // BRUTE FORCE APPROACH
        // int diff = 0;

        // for(int i = 0; i < prices.length; ++i) {
        //     for(int j = i + 1; j < prices.length; ++j) {
        //         if(prices[i] < prices[j]) {
        //             diff = Math.max(diff, prices[j] - prices[i]);
        //         }
        //     }
        // }

        // return diff;
    }
}