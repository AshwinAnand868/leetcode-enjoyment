class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] memo1 = new int[n];
        for (int i = 0; i < n; i++) memo1[i] = -1;
        int max1 = robLinear(nums, 0, n - 2, memo1);

        int[] memo2 = new int[n];
        for (int i = 0; i < n; i++) memo2[i] = -1;
        int max2 = robLinear(nums, 1, n - 1, memo2);

        return Math.max(max1, max2);
    }

    public int robLinear(int[] nums, int start, int end, int[] memo) {
        if(start > end) {
            return 0;
        }

        if(memo[start] != -1) return memo[start];

        int pick = nums[start] + robLinear(nums, start + 2, end, memo);
        int nonPick = robLinear(nums, start + 1, end, memo);

        memo[start] = Math.max(pick, nonPick);

        return memo[start];
    }
}