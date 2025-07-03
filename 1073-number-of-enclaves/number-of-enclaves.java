class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;

        for(int i = 0; i < m; ++i) {
            if(grid[i][0] == 1) {
                dfs(i, 0, grid);
            }

            if(grid[i][n- 1] ==1) {
                dfs(i, n - 1, grid);
            }
        }

        for(int j = 0; j < n; ++j) {
            if(grid[0][j] == 1) {
                dfs(0, j, grid);
            }

            if(grid[m - 1][j] == 1) {
                dfs(m - 1, j, grid);
            }
        }

        int count = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = -1;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int ni = dx[d] + i;
            int nj = dy[d] + j;
            dfs(ni, nj, grid);
        }
    }
}