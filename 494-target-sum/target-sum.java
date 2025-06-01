class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // if absolute value of target is more than totalSum, not possible
        if (Math.abs(target) > totalSum) return 0;

        int offset = totalSum;

        int[][] dp = new int[n][2 * totalSum + 1];

        if(nums[0] == 0) {
            dp[0][offset] = 2; // +0 and -0 both give same results
        } else {
            dp[0][nums[0] + offset] = 1;
            dp[0][-nums[0] + offset] = 1;
        }

        for(int i = 1; i < n; ++i) {
            for(int sum = -totalSum; sum <= totalSum; ++sum) {
                int pos = offset + sum;

                int plus = 0;
                int minus = 0;

                if((sum + nums[i]) + offset <= 2 * totalSum) {
                    plus = dp[i - 1][(sum + nums[i]) + offset];
                }

                if((sum - nums[i]) + offset >= 0) {
                    minus = dp[i - 1][(sum - nums[i]) + offset];
                }

                dp[i][pos] = plus + minus;
            }
        }

        return dp[n - 1][target + offset];
    }
}