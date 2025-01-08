class Solution {

    public int solve(int[] nums, boolean mustPick, int i, int[][] dp) {
        // Base case: If we reach the end of the array
        // If mustPick is false, return a large negative value to indicate invalid case
        if (i >= nums.length) return mustPick ? 0 : Integer.MIN_VALUE;

        int pickIndex = mustPick ? 1: 0;

        if(dp[pickIndex][i] != -1) {
            return dp[pickIndex][i];
        }

        // If mustPick is true, either stop here or include nums[i] and recurse
        if (mustPick) {
            return dp[pickIndex][i] = Math.max(0, nums[i] + solve(nums, true, i + 1, dp));
        }

        // If mustPick is false, explore both including and excluding the current element
        return dp[pickIndex][i] = Math.max(solve(nums, false, i + 1, dp), nums[i] + solve(nums, true, i + 1, dp));
    }

    public int maxSubArray(int[] nums) {
        int[][] dp = new int[2][nums.length];
        
        for(int[] row: dp)  {
            Arrays.fill(row, -1);
        }

        return solve(nums, false, 0, dp);
        // Recursion


        // Kadane's algoithm

        // int sum = 0;
        // int maxSum = Integer.MIN_VALUE;

        // for(int i = 0; i < nums.length; ++i) {
        //     sum += nums[i];

        //     maxSum = Math.max(maxSum, sum);

        //     if(sum < 0) {
        //         sum = 0;
        //     }
        // }

        // return maxSum;

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