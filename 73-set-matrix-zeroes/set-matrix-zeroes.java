class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) {
                    // set the corresponding ith row and 0th col to 0
                    matrix[i][0] = 0;

                    if(j != 0) {
                        // if j is not 0, the the corresponding column and 0th row
                        // will be marked as 0
                        matrix[0][j] = 0;
                    } else {
                        // if the j itself then we have marked the ith row as already 0
                        // so the whole column j will have 0 values
                        col0 = 0;
                    }
                }
            }
        }

        // start from bottom right corner
        for(int i = m - 1; i >= 1; i--) {
            for(int j = n - 1; j >= 1; j--) {
                if(matrix[i][j] != 0 && (matrix[0][j] == 0 || matrix[i][0] == 0)) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int j = 0; j < n; ++j) {
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0) {
            for(int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }      
    }
}