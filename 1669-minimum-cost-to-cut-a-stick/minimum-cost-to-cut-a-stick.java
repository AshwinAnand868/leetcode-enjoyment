class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> cutsList = new ArrayList<>();
        cutsList.add(0);
        cutsList.add(n);

        int cn = cuts.length;
        int[][] memo = new int[cn + 1][cn + 1];
        
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        for(int i = 0; i < cuts.length; ++i) {
            cutsList.add(cuts[i]);
        }

        Collections.sort(cutsList);

        return helper(cutsList, 1, cuts.length, memo);
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