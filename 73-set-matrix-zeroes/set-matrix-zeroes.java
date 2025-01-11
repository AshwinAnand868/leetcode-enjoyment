class Solution {

    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                if(row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    // public void setZeroes(int[][] matrix) {

    //     boolean containsZero = false;

    //     for (int i = 0; i < matrix.length; ++i) {
    //         for (int j = 0; j < matrix[i].length; ++j) {
    //             if (matrix[i][j] == 0) {
    //                 setRowValuesToMinusOne(i, matrix);
    //                 setColValuesToMinusOne(j, matrix);
    //                 containsZero = true;
    //             }
    //         }
    //     }

    //     if (containsZero) {
    //         for (int i = 0; i < matrix.length; ++i) {
    //             for (int j = 0; j < matrix[i].length; ++j) {
    //                 if (matrix[i][j] == -1) {
    //                     matrix[i][j] = 0;
    //                 }
    //             }
    //         }
    //     }
    // }

    // private void setRowValuesToMinusOne(int row, int[][] matrix) {
    //     for (int i = 0; i < matrix[0].length; ++i) {
    //         if (matrix[row][i] != 0) {
    //             matrix[row][i] = -1;
    //         }
    //     }
    // }

    // private void setColValuesToMinusOne(int col, int[][] matrix) {
    //     for (int i = 0; i < matrix.length; ++i) {
    //         if (matrix[i][col] != 0) {
    //             matrix[i][col] = -1;
    //         }
    //     }
    // }
}