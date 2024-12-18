class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        boolean valueUpdated = false;
        int[] finalPrices = new int[n];

        // int[] finalPrices = Arrays.copyOf(prices, n); 
        
        for(int i = 0; i < n; ++i) {
            int price = prices[i];
            valueUpdated = false;
            
            for(int j = i + 1; j < n; ++j) {
                if(prices[j] <= price) {
                    finalPrices[i] = price - prices[j];
                    valueUpdated = true;
                    break;
                }
            }
            
            if(!valueUpdated) {
                finalPrices[i] = prices[i];
            }
        }
        
        return finalPrices;
    }
}