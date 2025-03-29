class Solution {
    
    private int backtrack(int[] nums, int index, int previousIndex, int[][] dp) {
        if(index >= nums.length) { // if index goes out of bounds, return 0 - no LIS to consider
            return 0;
        }

        if(previousIndex != -1 && dp[index][previousIndex] != -1) {
            return dp[index][previousIndex];
        }

        // take current index

        int take = 0;
        if(previousIndex == -1 || nums[index] > nums[previousIndex]) {
            take = backtrack(nums, index + 1, index, dp) + 1;
        }

        int skip = backtrack(nums, index + 1, previousIndex, dp);

        if(previousIndex != -1) {
            dp[index][previousIndex] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {

        // track the LIS till each index i
        int[] dp = new int[nums.length];

        // initially each LIS is of length 1
        Arrays.fill(dp, 1);

        int maxLength = 1; // initial max length is 1 only
        int n = nums.length;

        for(int i = 0; i < n; ++i) { // loop through each element of nums
            for(int j = 0; j < i; ++j) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(dp[i], maxLength);
                }
            }
        }

        return maxLength;

        // int n = nums.length;
        // int[][] dp = new int[n + 1][n + 1];
        // for(int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // return backtrack(nums, 0, -1, dp);
    }
}
