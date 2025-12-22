class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int counter = 1;
        int m = n;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        int dir = 0;

        while(top <= bottom && left <= right) {
            // left to right
            if(dir == 0) {
                for(int i = left; i <= right; ++i) {
                    result[top][i] = counter++;
                }

                top++;
            }

            if(dir == 1) {
                for(int i = top; i <= bottom; ++i) {
                    result[i][right] = counter++;
                }
                right--;
            }

            if(dir == 2) {
                for(int i = right; i >= left; --i) {
                    result[bottom][i] = counter++;
                }
                bottom--;
            }

            if(dir == 3) {
                for(int i = bottom; i >= top; --i) {
                    result[i][left] = counter++;
                }
                left++;
            }

            dir = (dir + 1) % 4;
        }

        return result;
    }
}