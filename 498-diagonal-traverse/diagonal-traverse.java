class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(mat[i][j]);
            }
        }

        for(int key: map.keySet()) {
            if(key % 2 == 0) {
                Collections.reverse(map.get(key));
            }
        }

        int[] result = new int[m * n];
        int index = 0;

        for(int i = 0; i <= m + n - 2; ++i) {
            List<Integer> values = map.get(i);
            for(int value: values) {
                result[index++] = value;
            }
        }

        return result;
    }
}