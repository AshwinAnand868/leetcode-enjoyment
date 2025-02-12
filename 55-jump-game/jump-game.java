class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0; // tracks the farthest possible index we can reach

        for(int i = 0; i < nums.length; ++i) {
            if(reachable > nums.length - 1) {
                return true;
            }

            if(reachable < i) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;
    }
}