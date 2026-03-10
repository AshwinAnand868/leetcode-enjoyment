class Solution {

    public int minSubarraySum(int[] nums) {
        int sum = nums[0];
        int n = nums.length;
        int minSum = nums[0];

        for(int i = 1; i < n; ++i) {
            sum = Math.min(sum + nums[i], nums[i]);
            minSum = Math.min(minSum, sum);
        }

        return minSum;
    }

    public int maxSubarraySum(int[] nums) {
        int sum = nums[0];
        int n = nums.length;
        int maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = maxSubarraySum(nums);
        int minSum = minSubarraySum(nums);

        int totalSum = 0;
        for(int i = 0; i < nums.length; ++i) {
            totalSum += nums[i];
        }

        int circularSum = totalSum - minSum;

        if(maxSum > 0) {
            return Math.max(circularSum, maxSum);
        }

        return maxSum;
    }
}