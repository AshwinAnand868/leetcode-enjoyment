class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> balloonsList = new ArrayList<>();
        balloonsList.add(1);
        for (int num : nums) {
            balloonsList.add(num);
        }
        balloonsList.add(1);

        int n = nums.length;

        int[][] dp = new int[n + 2][n + 2];

        for(int i = n; i >= 1; --i) {
            for(int j = i; j <= n; ++j) {
                int max = 0;

                for (int k = i; k <= j; ++k) {
                    int coins = balloonsList.get(i - 1) * balloonsList.get(k) * balloonsList.get(j + 1) + dp[i][k - 1] + dp[k + 1][j];

                    max = Math.max(max, coins);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];

        // Integer[][] dp = new Integer[n + 2][n + 2];

        // return helper(balloonsList, 1, n, dp);
    }

    private int helper(List<Integer> b, int i, int j, Integer[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != null) return dp[i][j];

        int max = 0;

        for (int k = i; k <= j; ++k) {
            int coins = b.get(i - 1) * b.get(k) * b.get(j + 1)
                      + helper(b, i, k - 1, dp)
                      + helper(b, k + 1, j, dp);

            max = Math.max(max, coins);
        }

        dp[i][j] = max;
        return max;
    }
}
