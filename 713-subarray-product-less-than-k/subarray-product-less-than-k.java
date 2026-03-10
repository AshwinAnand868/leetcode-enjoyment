class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0, j = 0;
        int n = nums.length;
        long prod = 1;
        int result = 0;

        if(k == 0) return 0;

        while(j < n) {
            prod *= nums[j];

            while(i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }

            result += (j - i + 1);
            j++;
        }

        return result;
    }
}