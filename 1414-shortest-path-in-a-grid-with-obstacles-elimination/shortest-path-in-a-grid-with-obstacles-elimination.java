class Triplet {
    int i;
    int j;
    int k;

    Triplet(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
}

class Solution {
    int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Triplet> queue = new LinkedList<>();
        queue.offer(new Triplet(0, 0, k));

        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][k] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Triplet curr = queue.poll();

                int curr_i = curr.i;
                int curr_j = curr.j;
                int curr_obs = curr.k;

                if (curr_i == m - 1 && curr_j == n - 1) {
                    return steps;
                }

                for (int[] dir : dirs) {
                    int new_i = curr_i + dir[0];
                    int new_j = curr_j + dir[1];

                    if (new_i < 0 || new_i >= m || new_j < 0 || new_j >= n) {
                        continue;
                    }

                    if (grid[new_i][new_j] == 0 && !visited[new_i][new_j][curr_obs]) {
                        visited[new_i][new_j][curr_obs] = true;
                        queue.offer(new Triplet(new_i, new_j, curr_obs));
                    } 
                    else if (grid[new_i][new_j] == 1 && curr_obs > 0
                             && !visited[new_i][new_j][curr_obs - 1]) {
                        visited[new_i][new_j][curr_obs - 1] = true;
                        queue.offer(new Triplet(new_i, new_j, curr_obs - 1));
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}