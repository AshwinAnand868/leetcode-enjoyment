class Solution {
    public int lengthOfLIS(int[] nums) {
        // TABULATION ALGORITHM
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int maxLen = 1;

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < i; ++j) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}