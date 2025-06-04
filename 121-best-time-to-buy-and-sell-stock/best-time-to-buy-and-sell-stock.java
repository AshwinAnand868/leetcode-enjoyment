class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        // minprice found so far from 0 to i - 1
        int minPrice = prices[0];

        for(int i = 1; i < n; ++i) {
           int currProfit = prices[i] - minPrice;
           maxProfit = Math.max(currProfit, maxProfit); // max profit
           minPrice = Math.min(minPrice, prices[i]); // buying price
        }

        return maxProfit;
    }
}