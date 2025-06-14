class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(arr, n, k, 0, dp);
    }

    private int helper(int[] arr, int n, int k, int index, int[] dp) {
        if(index == n) {
            return 0; // no array left for partition
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int maxVal = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        int len = 0;
        int sum = 0;

        for(int i = index; i < Math.min(index + k, n); ++i) { // partition
            maxVal = Math.max(maxVal, arr[i]);
            len++;
            sum = maxVal * len + helper(arr, n, k, i + 1, dp);
            maxAns = Math.max(maxAns, sum);
        }

        return dp[index] = maxAns;
    }
}