class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // count squares having same bottom right at each cell

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; ++i) {
            dp[i][0] = matrix[i][0];
        }

        for(int j = 0; j < m; ++j) {
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1; i < n; ++i) {
            for(int j = 1; j < m; ++j) {
                if(matrix[i][j] == 0) {
                    dp[i][j] = 0; // no square can have bottom right as 0
                } else {
                    int min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    min = Math.min(min, dp[i][j - 1]);
                    dp[i][j] = min + 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }
}