class Solution {

    private int helper(int[] coins, int target, int index, int[][] memo) {

        if(target == 0)
            return 0;

        if(index == 0) {

            if(target % coins[0] == 0)
                return memo[index][target] = target / coins[0];

            return memo[index][target] = (int)1e9;
        }

        if(memo[index][target] != -1)
            return memo[index][target];

        int take = (int)1e9;

        if(target >= coins[index]) {
            take = 1 + helper(coins, target - coins[index], index, memo);
        }

        int skip = helper(coins, target, index - 1, memo);

        return memo[index][target] = Math.min(take, skip);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
        int[][] memo = new int[n + 1][m + 1];

        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        int result = helper(coins, amount, n - 1, memo);
        return result == (int) 1e9 ? -1 : result;

    }
}