class Solution {
    int m;
    int n;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // dfs only boundary cells which are ones
    private void dfs(int[][] grid, int r, int c) {

        // out of bounds or 0 case
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return;
        }

        grid[r][c] = 0; // remove land

        for(int[] dir : dirs) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for(int i = 0; i < m; ++i) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for(int j = 0; j < n; ++j) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        int ones = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    ones++;
                }
            }
        }

        return ones;
    }
}