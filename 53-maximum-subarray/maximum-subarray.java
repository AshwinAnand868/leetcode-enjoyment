class Solution {
    public int maxSubArray(int[] nums) {

        // Kadane's algoithm

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];

            maxSum = Math.max(maxSum, sum);

            if(sum < 0) {
                sum = 0;
            }
        }

        return maxSum;

        // int runningSum = 0;
        // int maxSum = Integer.MIN_VALUE;

        // if(nums.length == 1) {
        //     return nums[0];
        // }
        
        // for(int i = 0; i < nums.length; ++i) {
        //     runningSum = 0;
        //     for(int j = i; j < nums.length; ++j) {
        //         runningSum += nums[j];
        //         maxSum = Math.max(maxSum, runningSum);
        //     }
        // }
        
        // return maxSum;
    }
}