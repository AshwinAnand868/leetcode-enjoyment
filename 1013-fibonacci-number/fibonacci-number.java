class Solution {
    public int fib(int n) {
        if(n <= 1) return n;

        int[] dp = new int[n + 1]; // 0-index based size
        Arrays.fill(dp, -1);
        fibHelper(dp, n);
        return dp[n];
    }

    public int fibHelper(int[] dp, int n) {
        if(n <= 1) return n;

        if(dp[n] != -1) {
            return dp[n];
        }

        dp[n] = fibHelper(dp, n - 1) + fibHelper(dp, n - 2);

        return dp[n];
    }
}