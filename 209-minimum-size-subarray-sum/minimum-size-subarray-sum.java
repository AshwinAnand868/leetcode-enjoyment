class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        if(nums.length == 1) {
            if(nums[0]>= target) {
                return 1;
            } else {
                return 0;
            }
        }

        int i = 0;
        int j = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;

        while(j < nums.length) {
            sum += nums[j];

            while(sum >= target) {
                len = Math.min(len, j - i + 1);
                sum = sum - nums[i];
                i++;
            }

            j++;
        }

        if(len == Integer.MAX_VALUE) { // no valid subarray found
            return 0;
        } else {
            return len;
        }
    }
}