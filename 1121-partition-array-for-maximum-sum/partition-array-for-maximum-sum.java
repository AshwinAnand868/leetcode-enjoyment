class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);

        // return helper(arr, n, k, 0, dp);
        int[] dp = new int[n + 1];

        for(int i = n - 1; i >= 0; --i) {
            int maxVal = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            int len = 0;
            int sum = 0;

            for(int j = i; j < Math.min(i + k, n); ++j) { // partition
                maxVal = Math.max(maxVal, arr[j]);
                len++;
                sum = maxVal * len + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[i] = maxAns;
        }

        return dp[0];
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