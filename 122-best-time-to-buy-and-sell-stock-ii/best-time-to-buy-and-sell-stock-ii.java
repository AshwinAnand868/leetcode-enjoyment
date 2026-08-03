class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int totalProfit = 0;

        for(int i = 0; i < n - 1; ++i) {
            int curr =prices[i];
            int next = prices[i + 1];

            int netProfit = next - curr;

            if(netProfit < 0) netProfit = 0;

            totalProfit += netProfit;
        }

        return totalProfit;
    }
}