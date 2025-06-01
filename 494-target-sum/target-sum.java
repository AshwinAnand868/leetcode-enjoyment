class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // if absolute target exceeds totalSum, it's not possible
        if (Math.abs(target) > totalSum) return 0;


        // the sum index could go negative
        int[][] memo = new int[n][2 * totalSum + 1];

        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return helper(nums, target, n - 1, 0, memo, totalSum);
    }

    private int helper(int[] nums, int target, int index, int runningSum, int[][] memo, int totalSum) {
        if(index < 0) { // when all elemnts are used
            return runningSum == target ? 1 : 0;
        }

        int shiftedIndex = runningSum + totalSum;

        if(memo[index][shiftedIndex] != -1) {
            return memo[index][shiftedIndex];
        }

        // take
        int plus = helper(nums, target, index - 1, runningSum + nums[index], memo, totalSum);

        // skip
        int minus = helper(nums, target, index - 1, runningSum - nums[index], memo, totalSum);

        return memo[index][shiftedIndex] = plus + minus;
    }
}