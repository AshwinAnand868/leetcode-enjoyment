class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = nums[0]; // populate the base case

        for(int i = 1; i < n; ++i) {
            int pick = nums[i];

            if(i > 1) {
                pick += dp[i - 2];
            }
            int nonPick = dp[i - 1];

            dp[i] = Math.max(pick, nonPick);
        }

        return dp[n - 1];
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
