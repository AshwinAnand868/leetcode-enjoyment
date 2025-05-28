class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, cannot partition into equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        return subsetWithTargetExists(nums, target);
    }

    public boolean subsetWithTargetExists(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];

        // Base case: zero sum is always possible (empty subset)
        for (int i = 0; i < n; ++i) {
            dp[i][0] = true;
        }

        // Base case: first element can form a subset if it's <= target
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; ++i) {
            for (int varTarget = 1; varTarget <= target; varTarget++) {
                boolean notPick = dp[i - 1][varTarget];
                boolean pick = false;
                if (nums[i] <= varTarget) {
                    pick = dp[i - 1][varTarget - nums[i]];
                }

                dp[i][varTarget] = pick || notPick;
            }
        }

        return dp[n - 1][target];
    }
}