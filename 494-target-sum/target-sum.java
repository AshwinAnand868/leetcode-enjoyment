class Solution {
    static final int MOD = (int) 1e9 + 7;

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            totalSum += nums[i];
        }

        // Check for invalid conditions
        if (totalSum < Math.abs(target) || (totalSum - target) % 2 != 0) {
            return 0;
        }

        int subsetSum = (totalSum - target) / 2;
        return countSubsetSum(nums, subsetSum);
    }

    public int countSubsetSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        // Base case
        // We can always make sum 0 — by taking nothing
        for (int i = 0; i < n; ++i) {
            dp[i][0] = 1;
        }

        // Special case handling for the first element
        if (nums[0] <= target) {
            if (nums[0] == 0) {
                dp[0][0] = 2; // take or not take
            } else {
                dp[0][nums[0]] = 1;
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= target; ++j) {
                int notPick = dp[i - 1][j];
                int pick = 0;
                if (nums[i] <= j) {
                    pick = dp[i - 1][j - nums[i]];
                }

                dp[i][j] = (pick + notPick) % MOD;
            }
        }

        return dp[n - 1][target];
    }
}
