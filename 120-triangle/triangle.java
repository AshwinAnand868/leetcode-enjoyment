class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];

        for (int j = 0; j < triangle.get(m - 1).size(); ++j) {
            dp[m - 1][j] = triangle.get(m - 1).get(j);
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = 0; j <= i; ++j) {
                int num = triangle.get(i).get(j);
                int down = num + dp[i + 1][j];
                int diagonal = num + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }
}