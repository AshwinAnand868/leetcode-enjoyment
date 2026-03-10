class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        // using just one loop with TC O(n) - learned
        
        int minOps = Integer.MAX_VALUE;
        
        // high inclusive, low exclusive
        for(int hi = 0, lo = -1, white = 0; hi < blocks.length(); ++hi) {
            white += blocks.charAt(hi) == 'W' ? 1 : 0;
            
            if(hi - lo >= k) // when diff reaches the window size
            {
                minOps = Math.min(minOps, white);
                
                // low exclusive
                white -= blocks.charAt(++lo) == 'W' ? 1 : 0;
            }
            
            
        }
        
        // using loops with TC O(n*k)
//         int minOps = Integer.MAX_VALUE;
//         int i, j;
//         int runningMinOps = 0; 
        
//         for(int x = 0; x < blocks.length(); x++) {
            
//             i = x;
//             j = k + i - 1;
            
//             if(j >= blocks.length()) break;
                
//             while(i <= j) {
//                 if(blocks.charAt(i) == 'W') {
//                     runningMinOps++;
//                 }
//                 i++;
//             }
            
//             minOps = Math.min(minOps, runningMinOps);
//             runningMinOps = 0;
            
//         }
        
        return minOps;
    }
}