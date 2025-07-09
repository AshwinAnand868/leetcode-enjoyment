class Solution {
    class Tuple {
        int effort;
        int row;
        int col;

        Tuple(int effort, int row, int col) {
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a, b) -> a.effort - b.effort);

        int n = heights.length;
        int m = heights[0].length;
        int[][] efforts = new int[n][m];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }

        efforts[0][0] = 0; // effort to reach top left cell is 0
        queue.offer(new Tuple(0, 0, 0)); 

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        while(!queue.isEmpty()) {
            Tuple it = queue.poll(); 

            int diff = it.effort; 
            int row = it.row; 
            int col = it.col;

            if(row == n-1 && col == m-1) return diff; 

            for(int i = 0;i<4;i++) {
                int newr = row + dx[i]; 
                int newc = col + dy[i];

                if(newr>=0 && newc >=0 && newr < n && newc < m) {

                    int newEffort = Math.max(
                        Math.abs(heights[row][col] - heights[newr][newc]), diff); 

                    if(newEffort < efforts[newr][newc]) {
                        efforts[newr][newc] = newEffort; 
                        queue.add(new Tuple(newEffort, newr, newc)); 
                    }
                }
            }
        }

        return 0;
    }
}