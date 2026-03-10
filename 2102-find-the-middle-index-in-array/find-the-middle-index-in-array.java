class Solution {
    public int findMiddleIndex(int[] nums) {
        
        int n = nums.length;

        // calculate cumultive sum from left
        int[] leftSum = new int[nums.length];
        leftSum[0] = nums[0];

        for(int i = 1; i < n; ++i) {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }

        int[] rightSum = new int[nums.length];
        rightSum[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; --i) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }

        for(int i = 0; i < n; i++) {
            if(leftSum[i] == rightSum[i]) {
                return i;
            }
        }

        return -1;
    }
}