class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] finalPrices = Arrays.copyOf(prices, n); 
        
        for(int i = 0; i < n; ++i) {
            int price = prices[i];
            
            for(int j = i + 1; j < n; ++j) {
                if(prices[j] <= price) {
                    finalPrices[i] = price - prices[j];
                    break;
                }
            }
        }
        
        return finalPrices;
    }
}