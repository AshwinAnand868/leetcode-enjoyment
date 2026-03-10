class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, List<Integer>> diagonalsMap = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(diagonalsMap.containsKey(i - j)) {
                    diagonalsMap.get(i - j).add(mat[i][j]);
                } else {
                    diagonalsMap.put(i - j, new ArrayList<>());
                    diagonalsMap.get(i - j).add(mat[i][j]);
                }
            }
        }

        for(List<Integer> diagonal : diagonalsMap.values()) {
            Collections.sort(diagonal);
        }

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; --j) {
                List<Integer> diagonal = diagonalsMap.get(i - j);
                mat[i][j] = diagonal.get(diagonal.size() - 1);
                diagonal.remove(diagonal.size() - 1);
            }
        }

        return mat;
    }
}