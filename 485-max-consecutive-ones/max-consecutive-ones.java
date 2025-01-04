class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int n = nums.length;
        int maxCount = 0;

        while(i < n) {

            int runningCount = 0;

            while(i < n && nums[i] == 1) {
                ++runningCount;
                ++i;
            }

            maxCount = Math.max(maxCount, runningCount);

            ++i;
        }
        
        return maxCount;

    }
}