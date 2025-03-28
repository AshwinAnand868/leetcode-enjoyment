class Solution {

    private int minCoins = Integer.MAX_VALUE;

    public int backtrack(int[] coins, int amount, int index, int[][] dp) {
        if(amount == 0) { 
            return 0;
        }

        if(amount < 0 || index >= coins.length) return Integer.MAX_VALUE;

        if(dp[index][amount] != -1) return dp[index][amount];

        int take = backtrack(coins, amount - coins[index], index, dp);
        if(take != Integer.MAX_VALUE) {
            take += 1;
        }

        int skip = backtrack(coins, amount, index + 1, dp);

        dp[index][amount] = Math.min(take, skip);
        return dp[index][amount];
    }

    public int coinChange(int[] coins, int amount) {
        // Arrays.sort(coins);
        
        // backtrack(coins, amount, 0, 0);
        // return minCoins == Integer.MAX_VALUE ? -1 : minCoins;

        // int[][] dp = new int[coins.length][amount + 1]; // Create memoization table
        // for (int[] row : dp) Arrays.fill(row, -1); // Initialize with -1 (uncomputed)

        // int result = backtrack(coins, amount, 0, dp);
        // return result == Integer.MAX_VALUE ? -1 : result;

        if(amount < 1) return 0;

        int[] minCoinsAtI = new int[amount + 1];

        for(int varyingAmount = 1; varyingAmount <= amount; ++varyingAmount) {
            minCoinsAtI[varyingAmount] = Integer.MAX_VALUE;

            for(int coin: coins) {
                if(coin <= varyingAmount && minCoinsAtI[varyingAmount - coin] != Integer.MAX_VALUE) {
                    minCoinsAtI[varyingAmount] = Math.min(minCoinsAtI[varyingAmount], 1 + minCoinsAtI[varyingAmount - coin]);
                }
            }
        }

        if(minCoinsAtI[amount] != Integer.MAX_VALUE) {
            return minCoinsAtI[amount];
        }

        return -1;

    }
}