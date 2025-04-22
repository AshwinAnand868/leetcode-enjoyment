class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroesCount = 0;
        int n = nums.length;
        int i = 0, j = 0;
        int maxLen = 0;

        while(j < n) {

            if(nums[j] == 0) zeroesCount++;

            while(zeroesCount > k) {
                if(nums[i] == 0) {
                    zeroesCount--;
                }

                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            ++j;
        }

        return maxLen;
    }
}