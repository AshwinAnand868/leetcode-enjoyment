class Solution {

    private void dfs(int i, int j, int[] totalPerimeter, int[][] grid, int m, int n) {
        // if the current indexes are out of bounds or current grid is water,
        // then we increment the boundary/perimeter
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            totalPerimeter[0]++;
            return;
        }

        if(grid[i][j] == -1) { // the grid has already been visited
            return;
        }

        grid[i][j] = -1; // that was land and we have marked it visited now

        // explore all four sides of it
        dfs(i + 1, j, totalPerimeter, grid, m, n);
        dfs(i - 1, j, totalPerimeter, grid, m, n);
        dfs(i, j + 1, totalPerimeter, grid, m, n);
        dfs(i, j - 1, totalPerimeter, grid, m, n);

    }

    // Using DFS
    public int islandPerimeter(int[][] grid) {
        int[] totalPerimeter = new int[1];
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) { // stepped into the land, so explore the whole island
                    dfs(i, j, totalPerimeter, grid, m, n);
                    return totalPerimeter[0];
                }
            }
        }

        return -1;
    }
}