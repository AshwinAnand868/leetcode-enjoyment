class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] next = new int[n + 1]; // by default all 0s
        int[] curr = new int[n + 1]; // //

        for(int i = n - 1; i >= 0; i--) {
            for(int prev = i - 1; prev >= -1; prev--) {
                int skip = 0 + next[prev + 1];

                int take = 0;
                if(prev == -1 || nums[i] > nums[prev]) {
                    take = 1 + next[i + 1];
                }
                curr[prev + 1] = Math.max(take, skip);
            }
            next = curr.clone();
        }

        return curr[-1 + 1];
    }
}