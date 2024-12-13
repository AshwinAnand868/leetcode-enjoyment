class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int maxPrices = 0;
        int n = prizePositions.length;
        int[] dp = new int[n];
        int j = 0; // left
        
        for(int i = 0; i < n; ++i) { // right
            while(prizePositions[i] - prizePositions[j] > k) {
                // decrease the window size
                ++j;
            }
            
            int currentAns = i - j + 1; // current window length
            if(j > 0) currentAns += dp[j - 1];
            
            maxPrices = Math.max(maxPrices, currentAns);
            
            int previousMax = 0;
            if(i > 0) previousMax = dp[i-1];
            dp[i] = Math.max(previousMax, i-j+1);
        }
        
        return maxPrices;
    }
}