class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long count = 0;
        long nSubarrays = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                count++;
            } else {
                count = 0;
            }

            nSubarrays += count;
        }

        return nSubarrays;
    }
}