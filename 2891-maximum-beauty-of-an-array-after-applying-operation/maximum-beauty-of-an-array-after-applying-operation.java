class Solution {
    public int maximumBeauty(int[] nums, int k) {
        
        // sort the array in ascending
        Arrays.sort(nums);
        
        int maxCount = 0;
        int left = 0;
        
        for(int right = 0; right < nums.length; ++right) {
            
            /*
                The idea is to calculate the ranges of each number
                and to find out if they overlap. For that, we can
                use the below condition:
                
                nums[right] - k <= nums[left] + k
                nums[right] - nums[left] <= 2 * k
            */
            while(nums[right] - nums[left] > 2 * k) {
                left++; // shrink the window
            }
            
            maxCount = Math.max(maxCount, right - left + 1);
            
        }
        
        return maxCount;
        
        
        // fails for certain cases as the approach is not correct
//         int count;
//         int maxCount = 1;
        
//         for(int i = 0; i < nums.length; ++i) {
//             count = 0;
//             int firstRangeVal = nums[i] - k;
//             int lastRangeVal = nums[i] + k;
            
//             for(int j = 0; j < nums.length; ++j) {
//                 if(nums[j] >= firstRangeVal && nums[j] <= lastRangeVal) {
//                     count++; 
//                 }
//             }
            
//             maxCount = Math.max(maxCount, count);
//         }
        
//         return maxCount;
    }
}