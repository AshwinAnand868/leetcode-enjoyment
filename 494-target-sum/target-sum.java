class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;

        for(int num : nums) {
            totalSum += num;
        }

        int[][] memo = new int[nums.length][2 * totalSum + 1];

        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return calcWays(nums, target, 0, 0, memo, totalSum);
    }

    public int calcWays(int[] nums, int target, int currentSum, int index, int[][] memo, int totalSum) {
        if(index == nums.length) {
            if(currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        if(memo[index][currentSum + totalSum] != -1) {
            return memo[index][currentSum + totalSum];
        }

        int plus = calcWays(nums, target, currentSum + nums[index], index + 1, memo, totalSum);
        int minus = calcWays(nums, target, currentSum - nums[index], index + 1, memo, totalSum);

        return memo[index][currentSum + totalSum] = plus + minus;
    }
}