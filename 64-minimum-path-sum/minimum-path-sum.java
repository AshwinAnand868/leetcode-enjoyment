class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return helper(0, 0, grid, m, n, memo);
    }

    public int helper(int i, int j, int[][] grid, int m, int n, int[][] memo) {
        if(i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if(i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        int current = grid[i][j];
        int down = helper(i + 1, j, grid, m, n, memo);
        int right = helper(i, j + 1, grid, m, n, memo);

        return memo[i][j] = current + Math.min(down, right);
    }
}