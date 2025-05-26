class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return robHelper(0, nums, dp);
    }

    public int robHelper(int index, int[] nums, int[] dp) {
        if (index >= nums.length) return 0;

        if(dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + robHelper(index + 2, nums, dp);
        int skip = robHelper(index + 1, nums, dp);

        return dp[index] = Math.max(pick, skip);
    }
}
