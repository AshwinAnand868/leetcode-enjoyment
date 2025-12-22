class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        boolean found = false;

        for(int i = 0; i < m && !found; ++i) {
            for(int j = 0; j < n && !found; ++j) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                }
            }
        }

        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] curr = queue.poll();

                for(int[] dir : dirs) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];

                    if(newRow < 0 || newCol < 0 
                        || newRow >= m || newCol >= n) {
                        continue;
                    }

                    if(grid[newRow][newCol] == 1) {
                        return steps;
                    }

                    if(grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = -1;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        if(i < 0 || i >= grid.length || j < 0 || 
            j >= grid[0].length || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = -1;
        queue.offer(new int[] {i, j});

        for(int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], queue);
        }
    }
}