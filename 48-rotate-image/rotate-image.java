class Solution {
    public void rotate(int[][] matrix) {
        // populate a temp matrix
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] temp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                temp[i][j] = matrix[i][j];
            }
        }

        // update the temp matrix
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                temp[j][i] = matrix[m - i - 1][j];
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}