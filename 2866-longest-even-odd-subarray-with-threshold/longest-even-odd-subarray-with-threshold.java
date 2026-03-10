class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        
        int windowSize = 0;
        int r = 0;
        int flag = 0;
        int l = 0;

        while (r < nums.length) {
            if (flag == 0) {
                if (nums[r] % 2 == 0 && nums[r] <= threshold) {
                    l = r; // storing the starting index of the subarray for calculating windows sizes
                    windowSize = Math.max(windowSize, r - l + 1);
                    flag = 1;
                }
            } else if (flag == 1) {
                if (nums[r] % 2 != nums[r - 1] % 2 && nums[r] <= threshold) {
                    windowSize = Math.max(windowSize, r - l + 1);
                } else {
                    flag = 0;
                    r--;
                }
            }
            r++;
        }

        return windowSize;
        
        // O(n*k)   
//         for(int l = 0; l < nums.length; l++) {
//             if(nums[l] % 2 == 0 && nums[l] <= threshold) { // starting of the potential subarray
//                 r = l + 1; // result array needs to have at least one element
                
//                 while(r < nums.length) {
//                     if(nums[r] % 2 != nums[r-1] % 2 && nums[r] <= threshold) {
//                         r++;
//                     } else {
//                         break;
//                     }
//                 }
                
//                 windowSize = Math.max(windowSize, r - l);
                
//             }
           
//         }
        
        
    }
}