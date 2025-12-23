class Solution {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        // Queue element: {row, col, steps, current_key_status_decimal}
        Queue<int[]> queue = new LinkedList<>();

        int keyCount = 0;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                char ch = grid[i].charAt(j);

                if(ch == '@') {
                    queue.offer(new int[]{i, j, 0, 0});
                } else if(ch >= 'a' && ch <= 'f') {
                    keyCount++;
                }
            }
        }

        int finalKeyStatusDecimal = (1 << keyCount) - 1;

        boolean[][][] visited = new boolean[m][n][finalKeyStatusDecimal + 1];

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();

            int i = temp[0];
            int j = temp[1];
            int steps = temp[2];
            int currentKeyStatusDecimal = temp[3];

            if(currentKeyStatusDecimal == finalKeyStatusDecimal) {
                return steps;
            }

            for(int[] dir : directions) {
                int new_i = i + dir[0];
                int new_j = j + dir[1];

                if(new_i >= 0 && new_i < m && new_j >= 0 && 
                    new_j < n && grid[new_i].charAt(new_j) != '#') {
                    
                    char ch = grid[new_i].charAt(new_j);

                    if(ch >= 'A' && ch <= 'F') { // lock
                        if(!visited[new_i][new_j][currentKeyStatusDecimal]
                            && ((currentKeyStatusDecimal >> (ch - 'A')) & 1) == 1) {
                            
                            visited[new_i][new_j][currentKeyStatusDecimal] = true;
                            queue.offer(new int[] {new_i, new_j, steps + 1, currentKeyStatusDecimal});
                        }
                    }

                    else if(ch >= 'a' && ch <= 'f') {
                        int newKeyStatusDecimal = currentKeyStatusDecimal | (1 << (ch - 'a'));

                        if(!visited[new_i][new_j][newKeyStatusDecimal]) {
                            visited[new_i][new_j][newKeyStatusDecimal] = true;
                            queue.offer(new int[]{new_i, new_j, steps + 1, newKeyStatusDecimal});
                        }
                    } else {
                        if (!visited[new_i][new_j][currentKeyStatusDecimal]) {
                            visited[new_i][new_j][currentKeyStatusDecimal] = true;
                            queue.offer(new int[]{new_i, new_j, steps + 1, currentKeyStatusDecimal});
                        }
                    }
                }
            }
        }

        return -1;
    }
}