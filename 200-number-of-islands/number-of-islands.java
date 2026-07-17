class Solution {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void dfs(char[][] grid, boolean[][] vis, int i, int j, int m, int n) {
        vis[i][j] = true;

        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (newI >= 0 && newI < m &&
                newJ >= 0 && newJ < n &&
                grid[newI][newJ] == '1' &&
                !vis[newI][newJ]) {

                dfs(grid, vis, newI, newJ, m, n);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, vis, i, j, m, n);
                    count++;
                }
            }
        }

        return count;
    }
}