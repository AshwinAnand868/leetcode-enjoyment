class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        if (n == 1 && grid[0][0] == 0) return 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        int[][] vis = new int[n][n];
        vis[0][0] = 1;

        int steps = 1;

        int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
               int[] curr = queue.poll();
               int x = curr[0];
               int y = curr[1];

               // directions
               for(int d = 0; d < 8; ++d) {
                int newx = x + dx[d];
                int newy = y + dy[d];

                if (newx >= 0 && newx < n && newy >= 0 && 
                    newy < n && grid[newx][newy] == 0 && vis[newx][newy] == 0) {
                    vis[newx][newy] = 1;
                    queue.offer(new int[]{newx, newy});
                    if(newx == n - 1 && newy == n - 1) return steps + 1;
                }
               }
            }

            steps++;
        }

        return -1;
    }
}