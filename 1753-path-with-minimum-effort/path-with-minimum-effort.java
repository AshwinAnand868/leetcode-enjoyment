class Solution {
    public int minimumEffortPath(int[][] heights) {

        int[][] dirs = {{0,1}, {1,0}, {-1, 0}, {0, -1}};

        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.offer(new int[] {0,0,0});

        int[][] efforts = new int[m][n];

        for(int[] effort : efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }

        efforts[0][0] = 0;

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            int r = curr[0];
            int c = curr[1];
            int effort = curr[2];

            if(r == m - 1 && c == n - 1) {
                return effort;
            }

            if(effort > efforts[r][c]) continue;

            for(int[] dir : dirs) {
                int nRow = r + dir[0];
                int nCol = c + dir[1];

                if(nRow >= m || nCol >= n || nRow < 0 || nCol < 0) continue;

                int edgeCost = Math.abs(heights[nRow][nCol] - heights[r][c]);
                int newEffort = Math.max(effort, edgeCost); // max effort of this path


                if(newEffort < efforts[nRow][nCol]) {
                    efforts[nRow][nCol] = newEffort;
                    minHeap.offer(new int[] {nRow, nCol, newEffort});
                }
            }          
        }

        return -1;
    }
}