class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int windowSize = 0;
        int r = 0;
        int ans = 0;
        
        for(int l = 0; l < nums.length; l++) {
            if(nums[l] % 2 == 0 && nums[l] <= threshold) { // starting of the potential subarray
                r = l + 1; // result array needs to have at least one element
                
                while(r < nums.length) {
                    if(nums[r] % 2 != nums[r-1] % 2 && nums[r] <= threshold) {
                        r++;
                    } else {
                        break;
                    }
                }
                
                windowSize = Math.max(windowSize, r - l);
                
            }
           
        }
        
        return windowSize;
        
    }
}