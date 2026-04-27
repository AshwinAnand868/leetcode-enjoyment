class Solution {

    public void dfs(char[][] grid, int[][] dirs, int row, int col, int m, int n) {
        grid[row][col] = '0';
        
        for(int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            if(newRow >= 0 && newCol >= 0 &&
                newRow <= m - 1 && newCol <= n - 1 && grid[newRow][newCol] == '1') {
                dfs(grid, dirs, newRow, newCol, m, n);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == '1') {
                    dfs(grid, dirs, i, j, m, n);
                    count++;
                }
            }
        }

        return count;
    }
}