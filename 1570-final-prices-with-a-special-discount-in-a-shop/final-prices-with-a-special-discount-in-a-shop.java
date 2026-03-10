class Solution {
    public int[] finalPrices(int[] prices) {
        
        int n = prices.length;
        int[] finalPrices = Arrays.copyOf(prices, n);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; ++i) {

            // this is the tempalte for monotic stack
            // always there is a while loop that somehow makes 
            // our stack monotonic in nature 
            
            while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                finalPrices[stack.peek()] = prices[stack.peek()] - prices[i];
                stack.pop();
            }

            stack.push(i);
        }

        return finalPrices;
        
//         int n = prices.length;
//         boolean valueUpdated = false;
//         int[] finalPrices = new int[n];

//         // int[] finalPrices = Arrays.copyOf(prices, n); 
        
//         for(int i = 0; i < n; ++i) {
//             int price = prices[i];
//             valueUpdated = false;
            
//             for(int j = i + 1; j < n; ++j) {
//                 if(prices[j] <= price) {
//                     finalPrices[i] = price - prices[j];
//                     valueUpdated = true;
//                     break;
//                 }
//             }
            
//             if(!valueUpdated) {
//                 finalPrices[i] = prices[i];
//             }
//         }
        
//         return finalPrices;
    }
}