class Solution {
    public int[][] updateMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ans[i][j] = 0;
                    queue.add(new int[] { i, j });
                } else {
                    ans[i][j] = Integer.MAX_VALUE; // marking it as unsolved/unvisited
                }
            }
        }

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; ++k) {
                int[] pair = queue.poll();
                int i = pair[0], j = pair[1];

                for (int d = 0; d < 4; ++d) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && ans[ni][nj] == Integer.MAX_VALUE) {
                        ans[ni][nj] = 1 + ans[i][j];
                        queue.add(new int[] { ni, nj });
                    }
                }
            }
        }

        return ans;
    }
}