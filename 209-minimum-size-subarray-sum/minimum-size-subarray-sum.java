class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        // build a prefix sum array
        for(int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int minLen = Integer.MAX_VALUE;

        // Binary search for each i to find j
        for(int i = 0; i < n; ++i) {
            int required = prefixSum[i] + target;

            // searh space of prefix sum array is from 1 to 6 as its size is n + 1
            int left = i + 1;
            int right = n;

            while(left <= right) {
                int mid = (left + right) / 2;

                if(prefixSum[mid] >= required) {
                    minLen = Math.min(minLen, mid - i);
                    // reduce the search space
                    right = mid - 1; // move right to mid - 1 to find any other mid meeting the condition
                } else {
                    left = mid + 1;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;


        // Sliding Window Approach (O(n))
        // int i = 0;
        // int j = 0;
        // int sum = 0;
        // int len = Integer.MAX_VALUE;

        // while(j < nums.length) {
        //     sum += nums[j];

        //     while(sum >= target) {
        //         len = Math.min(len, j - i + 1);
        //         sum = sum - nums[i];
        //         i++;
        //     }

        //     j++;
        // }

        // if(len == Integer.MAX_VALUE) { // no valid subarray found
        //     return 0;
        // } else {
        //     return len;
        // }
    }
}