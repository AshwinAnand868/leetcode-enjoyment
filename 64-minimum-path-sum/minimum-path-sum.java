class Solution {
    public int recurse(int[][] grid, int m, int n, int i, int j, int[][] memo) {
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        if (j + 1 < n) {
            right = recurse(grid, m, n, i, j + 1, memo);
        }

        if (i + 1 < m) {
            down = recurse(grid, m, n, i + 1, j, memo);
        }

        return memo[i][j] = grid[i][j] + Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return recurse(grid, m, n, 0, 0, memo);
    }
}
