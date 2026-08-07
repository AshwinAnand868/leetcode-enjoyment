class Solution {

    private int helper(int[] coins, int amount, int index, int[][] memo) {
        
        if(index == coins.length || amount < 0) {
            return Integer.MAX_VALUE;
        }

        if(amount == 0) {
            return 0;
        }

        if(memo[index][amount] != -1) {
            return memo[index][amount];
        }

        // take this current coin
        int take = helper(coins, amount - coins[index], index, memo);

        if(take != Integer.MAX_VALUE) {
            take += 1;
        }

        // skip this current coin
        int skip = helper(coins, amount, index + 1, memo);

        memo[index][amount] = Math.min(take, skip);

        return memo[index][amount];
    }

    public int coinChange(int[] coins, int amount) {

        if(amount == 0) return 0;

        if(coins.length == 0 && amount > 0) {
            return -1;
        }

        int[][] memo = new int[coins.length][amount + 1];

        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        int result = helper(coins, amount, 0, memo);

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}