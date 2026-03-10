class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] != matrix[r - 1][c - 1]) {
                    return false;
                }
            }
        }

        return true;
        // HashMap<Integer, Integer> diagonalsMap = new HashMap<>();
        // int m = matrix.length;
        // int n = matrix[0].length;

        // for(int i = 0; i < m; ++i) {
        //     for(int j = 0; j < n; ++j) {
        //         if(diagonalsMap.containsKey(i - j)) {
        //             if(diagonalsMap.get(i - j) != matrix[i][j]) {
        //                 return false;
        //             }
        //         } else {
        //             diagonalsMap.put(i - j, matrix[i][j]);
        //         }
        //     }
        // }

        // return true;
    }
}