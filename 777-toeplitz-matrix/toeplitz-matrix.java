class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        HashMap<Integer, Integer> diagonalsMap = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(diagonalsMap.containsKey(i - j)) {
                    if(diagonalsMap.get(i - j) != matrix[i][j]) {
                        return false;
                    }
                } else {
                    diagonalsMap.put(i - j, matrix[i][j]);
                }
            }
        }

        return true;
    }
}