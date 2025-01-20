class Solution {
    public int subarraySum(int[] nums) {
        int totalSum = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for(int i = 1; i < nums.length; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for(int i = 0; i < nums.length; ++i) {
            int start = Math.max(0, i - nums[i]);
            totalSum += prefixSum[i];
            if(start - 1 >= 0) totalSum -= prefixSum[start - 1];
        }

        // for(int i = 0; i < nums.length; ++i) {
        //     int start = Math.max(0, i - nums[i]);

        //     for(int j = start; j <= i; ++j) {
        //         totalSum += nums[j];
        //     }
        // }

        return totalSum;
    }
}