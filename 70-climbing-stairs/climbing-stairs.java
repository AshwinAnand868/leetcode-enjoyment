class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];

        Arrays.fill(memo, -1);

        return climbStairsHelper(n, memo);
    }

    public int climbStairsHelper(int n, int[] memo) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(memo[n] != -1) {
            return memo[n];
        }

        int ways = climbStairsHelper(n - 1, memo);
        ways += climbStairsHelper(n - 2, memo);

        return memo[n] = ways;
    }
}