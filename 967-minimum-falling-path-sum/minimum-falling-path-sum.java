class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; ++j) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                int down = dp[i + 1][j];
                int left = (j > 0) ? dp[i + 1][j - 1] : (int) 1e9;
                int right = (j < n - 1) ? dp[i + 1][j + 1] : (int) 1e9;

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; ++j) {
            minSum = Math.min(minSum, dp[0][j]);
        }

        return minSum;
    }
}
