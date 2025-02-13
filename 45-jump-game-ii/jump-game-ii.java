class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[10001];
        Arrays.fill(memo, -1);
        return jumpHelper(nums, memo, 0);
    }

    private int jumpHelper(int[] nums, int[] memo, int pos) {
        // base case
        if(pos >= nums.length - 1) return 0;
        if(memo[pos] != -1) return memo[pos];

        int minJumps = 10001;

        for(int j = 1; j <= nums[pos]; ++j) {
            minJumps = Math.min(minJumps, 1 + jumpHelper(nums, memo, j + pos));
        }

        memo[pos] = minJumps;
        return minJumps;
    }
}