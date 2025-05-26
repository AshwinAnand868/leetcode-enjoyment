class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] memo1 = new int[n];
        Arrays.fill(memo1, -1);
        int amountRobbed1 = robHelper(0, n - 2, nums, memo1);

        int[] memo2 = new int[n];
        Arrays.fill(memo2, -1);
        int amountRobbed2 = robHelper(1, n - 1, nums, memo2);

        return Math.max(amountRobbed1, amountRobbed2);
    }

    public int robHelper(int start, int end, int[] moneyArray, int[] memo) {
        if(start > end) {
            return 0;
        }

        if(start == end) {
            return moneyArray[start];
        }

        if(memo[start] != -1) {
            return memo[start];
        }

        int pick = moneyArray[start] + robHelper(start + 2, end, moneyArray, memo);
        int nonPick = 0 + robHelper(start + 1, end, moneyArray, memo);

        return memo[start] = Math.max(pick, nonPick);
    }
}