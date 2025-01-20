class Pair {
    int i;
    int j;

    Pair() {
        this.i = 0;
        this.j = 0;
    }

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) { // land

                    if(i - 1 < 0 || grid[i-1][j] == 0) {
                        perimeter++;
                    }

                    if(i + 1 >= m || grid[i + 1][j] == 0) {
                        perimeter++;
                    }

                    if(j - 1 < 0 || grid[i][j-1] == 0) {
                        perimeter++;
                    }

                    if(j + 1 >= n || grid[i][j + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }

        return perimeter;
    }

    // public int bfs(int i, int j, int[][] grid, int m, int n) {
    //     int perimeter = 0;

    //     int[][] directions = new int[][] {
    //             { 0, 1 },
    //             { 1, 0 },
    //             { 0, -1 },
    //             { -1, 0 }
    //     };

    //     Queue<Pair> queue = new LinkedList<>();
    //     queue.add(new Pair(i,j));
    //     grid[i][j] = -1;

    //     while(!queue.isEmpty()) {
    //         Pair pair = queue.peek();
    //         queue.poll();

    //         for(int[] direction: directions) {
    //             int i1 = pair.i + direction[0];
    //             int j1 = pair.j + direction[1];

    //             // out of bound or water - increment boundary/peri
    //             if(i1 < 0 || j1 < 0 || i1 >= m || j1 >= n || grid[i1][j1] == 0) {
    //                 perimeter++;
    //             } else if(grid[i1][j1] == -1) {
    //                 continue;
    //             } else {
    //                 queue.offer(new Pair(i1, j1));
    //                 grid[i1][j1] = -1;
    //             }
    //         }
    //     }

    //     return perimeter;
    // }

    // // Using BFS
    // public int islandPerimeter(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;

    //     for (int i = 0; i < m; ++i) {
    //         for (int j = 0; j < n; ++j) {
    //             if (grid[i][j] == 1) { // stepped into the land, so explore the whole island
    //                 return bfs(i, j, grid, m, n);
    //             }
    //         }
    //     }

    //     return -1;
    // }

    // private void dfs(int i, int j, int[] totalPerimeter, int[][] grid, int m, int n) {
    //     // if the current indexes are out of bounds or current grid is water,
    //     // then we increment the boundary/perimeter
    //     if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
    //         totalPerimeter[0]++;
    //         return;
    //     }

    //     if(grid[i][j] == -1) { // the grid has already been visited
    //         return;
    //     }

    //     grid[i][j] = -1; // that was land and we have marked it visited now

    //     // explore all four sides of it
    //     dfs(i + 1, j, totalPerimeter, grid, m, n);
    //     dfs(i - 1, j, totalPerimeter, grid, m, n);
    //     dfs(i, j + 1, totalPerimeter, grid, m, n);
    //     dfs(i, j - 1, totalPerimeter, grid, m, n);

    // }

    // // Using DFS
    // public int islandPerimeter(int[][] grid) {
    //     int[] totalPerimeter = new int[1];
    //     int m = grid.length;
    //     int n = grid[0].length;

    //     for(int i = 0; i < m; ++i) {
    //         for(int j = 0; j < n; ++j) {
    //             if(grid[i][j] == 1) { // stepped into the land, so explore the whole island
    //                 dfs(i, j, totalPerimeter, grid, m, n);
    //                 return totalPerimeter[0];
    //             }
    //         }
    //     }

    //     return -1;
    // }
}