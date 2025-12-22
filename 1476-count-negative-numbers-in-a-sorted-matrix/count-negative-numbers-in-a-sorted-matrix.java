class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; ++i) {
            int left = 0;
            int right = n - 1;
            int firstNegativeIndex = n;

            while(left <= right) {
                int mid = (left + (right - left) / 2);

                if(grid[i][mid] < 0) {
                    firstNegativeIndex = mid;
                    right = mid - 1; // go to left side
                } else {
                    left = mid + 1;
                }
            }

            count += (n - firstNegativeIndex);
        }

        return count;
    }


}