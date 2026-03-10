class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        long count = 0;
        int lastMin = -1, lastMax = -1, outOfBounds = -1;

        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] < minK || nums[i] > maxK) {
                outOfBounds = i;
            }

            if(nums[i] == minK) {
                lastMin = i;
            }

            if(nums[i] == maxK) {
                lastMax = i;
            }


            int smaller = Math.min(lastMin, lastMax);
            int temp = smaller - outOfBounds;
            count += temp > 0 ? temp : 0;
        }

        return count;
    }
}