class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int minOps = Integer.MAX_VALUE;
        int i, j;
        int runningMinOps = 0; 
        
        for(int x = 0; x < blocks.length(); x++) {
            
            i = x;
            j = k + i - 1;
            
            if(j >= blocks.length()) break;
                
            while(i <= j) {
                if(blocks.charAt(i) == 'W') {
                    runningMinOps++;
                }
                i++;
            }
            
            minOps = Math.min(minOps, runningMinOps);
            runningMinOps = 0;
            
        }
        
        return minOps;
    }
}