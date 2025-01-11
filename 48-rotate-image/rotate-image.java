class Solution {

    private void transpose(int[][] matrix, int m, int n) {
        for(int i = 0; i < m; ++i) {
            for(int j = i + 1; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverse(int[] row) {
        int start = 0;
        int end = row.length - 1;

        while(start <= end) {
            
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;

            start++;
            end--;
        }
    }

    public void rotate(int[][] matrix) {

        transpose(matrix, matrix.length, matrix[0].length);

        for(int i = 0; i < matrix.length; ++i) {
            reverse(matrix[i]);
        }

    //     // populate another temp matrix which is a brute force approach
    //     int m = matrix.length;
    //     int n = matrix[0].length;

    //     int[][] temp = new int[m][n];   

    //     // update the temp matrix
    //     for (int i = 0; i < m; ++i) {
    //         for (int j = 0; j < n; ++j) {
    //             temp[j][i] = matrix[m - i - 1][j];
    //         }
    //     }

    //     for (int i = 0; i < m; ++i) {
    //         for (int j = 0; j < n; ++j) {
    //             matrix[i][j] = temp[i][j];
    //         }
    //     }
    }
}