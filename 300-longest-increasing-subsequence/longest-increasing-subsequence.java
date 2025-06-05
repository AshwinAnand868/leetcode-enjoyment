class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n + 1];

        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(nums, 0 , -1, memo);
    }

    private int helper(int[] nums, int index, int prevIndex, int[][] memo) {
        if(index == nums.length) {
            return 0;
        }

        if(memo[index][prevIndex + 1] != -1) { // if it is -1, then shift the index
            return memo[index][prevIndex + 1];
        }

        // skip the current num
        int skip = helper(nums, index + 1, prevIndex, memo);

        // take the current num
        int take = 0;
        if(prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + helper(nums, index + 1, index, memo);
        }

        return memo[index][prevIndex + 1] = Math.max(skip, take);
    }
}