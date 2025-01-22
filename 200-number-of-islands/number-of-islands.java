class Solution {

    private int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public boolean isSafe(char[][] grid, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            return true;
        }
        return false;
    }

    public void dfs(char[][] grid, int i, int j) {
        if(!isSafe(grid, i, j)) {
            return;
        }

        grid[i][j] = '$'; // mark it as visited

        for(int[] dir: directions) {
            int newI = dir[0] + i;
            int newJ = dir[1] + j;

            dfs(grid, newI, newJ);
        }
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;

    }
}