class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; ++i) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        // return maxProfit;









        // int minPrice = prices[0];

        // for(int i = 0; i < prices.length; ++i) {
        //     minPrice = Math.min(prices[i], minPrice);
        //     maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        // }

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