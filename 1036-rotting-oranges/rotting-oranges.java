class Pair {
    int i;
    int j;

    Pair(){}
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 2) {
                    // add all rotten oranges initially as
                    // they all will start rotting others
                    // simaltaneously
                    queue.add(new Pair(i, j));
                }
            }
        }

        int minutes = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;

            for(int k = 0; k < size; ++k) {
                Pair pair = queue.poll();
                int i = pair.i;
                int j = pair.j;

                for(int z = 0; z < 4; ++z) {
                    // all directions processing
                    int ni = i + dx[z];
                    int nj = j + dy[z];

                    if(ni < m && ni >= 0 && nj < n && nj >= 0 && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2; // marking rotten immediately
                        queue.add(new Pair(ni, nj));
                        flag = true;
                    }
                }
            }

            if(flag) minutes++;
        }

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }
}