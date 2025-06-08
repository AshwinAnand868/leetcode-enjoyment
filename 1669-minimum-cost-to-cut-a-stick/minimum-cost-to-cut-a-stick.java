class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> cutsList = new ArrayList<>();
        cutsList.add(0);
        cutsList.add(n);

        int cn = cuts.length;
        int[][] dp = new int[cn + 2][cn + 2];

        for(int i = 0; i < cuts.length; ++i) {
            cutsList.add(cuts[i]);
        }

        Collections.sort(cutsList);

        for(int i = cn; i >= 1; --i) {
            for(int j = i; j <= cn; ++j) {
                int min = Integer.MAX_VALUE;

                for(int k = i; k <= j; ++k) {
                    int cost = cutsList.get(j + 1) - cutsList.get(i - 1)
                        + dp[i][k - 1]
                        + dp[k + 1][j];
                    min = Math.min(cost, min);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][cn];

        // int[][] memo = new int[n][n];
        
        // for(int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }

        // return helper(cutsList, 1, cuts.length, memo);
    }

    private int helper(List<Integer> cutsList, int i, int j, int[][] memo) {
        if(i > j) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        int min = Integer.MAX_VALUE;

        for(int k = i; k <= j; ++k) {
            int cost = cutsList.get(j + 1) - cutsList.get(i - 1)
                + helper(cutsList, i, k - 1, memo) 
                + helper(cutsList, k + 1, j, memo);
            min = Math.min(cost, min);
        }

        return memo[i][j] = min;
    }
}