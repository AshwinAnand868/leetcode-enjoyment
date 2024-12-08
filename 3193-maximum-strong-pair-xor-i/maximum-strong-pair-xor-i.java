class Solution {
    public int maximumStrongPairXor(int[] nums) {
        
        int maxXor = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                int difference = Math.abs(nums[i] - nums[j]);
                
                int min = Math.min(nums[i], nums[j]);
                
                if(difference <= min) {
                    int xor = nums[i] ^ nums[j];
                    maxXor = Math.max(maxXor, xor);
                }
            }
        }
        
        return maxXor;
    }
}