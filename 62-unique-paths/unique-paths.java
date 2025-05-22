class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return uniquePathsHelper(m, n, 0, 0, memo);
    }

    public int uniquePathsHelper(int m, int n, int row, int col, int[][] dp) {
        if(row >= m || col >= n) {
            return 0;
        }

        if(row == m - 1 && col == n - 1) {
            return 1;
        }

        if (dp[row][col] != -1) return dp[row][col];

        dp[row][col] = uniquePathsHelper(m, n, row + 1, col, dp) + uniquePathsHelper(m, n, row, col + 1, dp);
        return dp[row][col];
    }
}