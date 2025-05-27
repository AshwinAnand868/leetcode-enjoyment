class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return uniquePathsHelper(m, n, 0, 0, memo);
    }

    public int uniquePathsHelper(int m, int n, int i, int j, int[][] memo) {
        if(i == m - 1 && j == n - 1) {
            return 1;
        }

        if(i >= m || j >= n) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        return memo[i][j] = uniquePathsHelper(m, n, i + 1, j, memo) + uniquePathsHelper(m, n, i, j + 1, memo);
    }
}