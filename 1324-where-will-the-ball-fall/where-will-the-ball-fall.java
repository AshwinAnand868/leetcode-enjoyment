class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] answer = new int[n];

        for(int ball = 0; ball < n; ++ball) {
            int row = 0;
            int col = ball;

            while(row < m && col < n) {
                if(grid[row][col] == 1) {
                    if(col == n - 1) {
                        col = -1;
                        break;
                    }

                    if(col + 1 < n && grid[row][col + 1] == -1) {
                        col = -1;
                        break;
                    }

                    col++;
                } else {
                     if(col == 0) {
                        col = -1;
                        break;
                    }

                    if(col > 0 && grid[row][col - 1] == 1) {
                        col = -1;
                        break;
                    }
                    col--;
                }

                row++;

            }
            answer[ball] = col;
        }

        return answer;
    }
}