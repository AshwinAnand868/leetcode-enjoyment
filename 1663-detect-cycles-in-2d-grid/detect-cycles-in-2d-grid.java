class Solution {
    int[][] dirs = {{1,0},{0, 1},{0, -1}, {-1,0}};

    public boolean dfs(char[][] grid, boolean[][] visited, int parentI, int parentJ,
        int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        visited[i][j] = true;

        for(int[] dir : dirs) {
            
            int newI = dir[0] + i;
            int newJ = dir[1] + j;

            if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[i][j] == grid[newI][newJ]) {     
                if(!visited[newI][newJ]) {
                    if(dfs(grid, visited, i, j, newI, newJ)) return true;
                }
                else if(newI != parentI
                    || newJ != parentJ){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length; 

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(!visited[i][j]) {
                    boolean result = dfs(grid, visited, -1, -1, i, j);

                    if(result) return true;
                }
            }
        }

        return false;
    }
}