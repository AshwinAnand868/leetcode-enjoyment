class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        int maxJump = 0;

        if(n == 2) {
            return stones[stones.length - 1];
        }

        // Forward traversal
        for(int i = 0; i + 2 < n; ++i) {
            maxJump = Math.max(maxJump, Math.abs(stones[i + 2] - stones[i]));
        }

        // Backward traversal
        for(int i = n - 1; i - 2 >= 0; --i) {
            maxJump = Math.max(maxJump, Math.abs(stones[i] - stones[i - 2]));
        }

        return maxJump;
    }
}