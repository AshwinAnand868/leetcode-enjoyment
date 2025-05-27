class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] memo = new int[m][m + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1); // mark all as uncomputed
        }

        return helper(0, 0, m, triangle, memo);
    }

    public int helper(int i, int j, int m, List<List<Integer>> triangle, int[][] memo) {
        if(i == m - 1) { // after reaching last row
            return triangle.get(i).get(j);
        }

        if (memo[i][j] != -1) {
            return memo[i][j]; // use cached result
        }

        int down = helper(i + 1, j, m, triangle, memo);
        int diagonal = helper(i + 1, j + 1, m, triangle, memo);

        return memo[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }
}