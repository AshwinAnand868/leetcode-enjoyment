class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recursive(nums, 0, 0, target);
    }

    private int recursive(int[] nums, int currentIdx, int currentSum, int target) {
        if(currentIdx == nums.length) {
            if(currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        } 

        // exploring both possibilities for each integer
        int plus = recursive(nums, currentIdx + 1, currentSum + nums[currentIdx], target);
        int minus = recursive(nums, currentIdx + 1, currentSum - nums[currentIdx], target);

        return plus + minus;
    }
}