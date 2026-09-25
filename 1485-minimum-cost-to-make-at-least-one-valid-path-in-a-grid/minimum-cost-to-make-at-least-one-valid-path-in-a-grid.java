class Solution {
    public int minCost(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];

        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0,0});

        dist[0][0] = 0;

        while(!dq.isEmpty()) {
            // we will poll from first
            int[] current = dq.pollFirst();

            int x = current[0], y = current[1];

            for(int dir = 0; dir < 4; ++dir) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                int cost = (grid[x][y] == dir + 1) ? 0 : 1;

                if(dist[x][y] + cost < dist[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + cost;

                    if(cost == 0) {
                        dq.offerFirst(new int[]{nx, ny});
                    } else {
                        dq.offerLast(new int[] {nx, ny});
                    }
                }
            }
        }

        return dist[m - 1][ n - 1];
    }
}