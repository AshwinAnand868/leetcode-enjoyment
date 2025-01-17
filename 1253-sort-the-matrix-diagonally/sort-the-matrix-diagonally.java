class Solution {

    public int[][] diagonalSort(int[][] mat) {

                Map<Integer, PriorityQueue<Integer>> diagonalsMap = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        // Insert elements into the appropriate priority queue
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                diagonalsMap.putIfAbsent(i - j, new PriorityQueue<>());
                diagonalsMap.get(i - j).offer(mat[i][j]);
            }
        }

        // Extract and place sorted elements back into the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = diagonalsMap.get(i - j).poll();
            }
        }

        return mat;
        
        // Map<Integer, List<Integer>> diagonalsMap = new HashMap<>();
        // int m = mat.length;
        // int n = mat[0].length;

        // for (int i = 0; i < m; ++i) {
        //     for (int j = 0; j < n; ++j) {
        //         if (diagonalsMap.containsKey(i - j)) {
        //             diagonalsMap.get(i - j).add(mat[i][j]);
        //         } else {
        //             List<Integer> list = new ArrayList<>();
        //             list.add(mat[i][j]);
        //             diagonalsMap.put(i - j, list);
        //         }

        //     }
        // }

        // // sort the diagonals
        // for (List<Integer> diagonal : diagonalsMap.values()) {
        //     Collections.sort(diagonal);
        // }

        // // now we will put them back in sorted fashion
        // for (int i = m - 1; i >= 0; i--) {
        //     for (int j = n - 1; j >= 0; --j) {
        //         List<Integer> diagonal = diagonalsMap.get(i - j);
        //         mat[i][j] = diagonal.get(diagonal.size() - 1); // get the last element of the current diagonal list
        //         diagonal.remove(diagonal.size() - 1); // remove the last element of the current diagonal list
        //     }
        // }

        // return mat;
    }
}