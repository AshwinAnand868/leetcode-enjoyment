class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] memo = new int[m][n];

        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return helper(obstacleGrid, 0, 0, m - 1, n - 1, memo);
    }

    public int helper(int[][] grid, int i, int j, int m, int n, int[][] memo) {

        if(i > m || j > n) {
            return 0;
        }

        if(i == m && j == n) {
            return 1;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        if(grid[i][j] == 1) {
            return memo[i][j] = 0; // 0 ways to reach this obstacle cell
        }

        return memo[i][j] = helper(grid, i + 1, j, m, n, memo) + helper(grid, i, j + 1, m, n, memo);
    }
}