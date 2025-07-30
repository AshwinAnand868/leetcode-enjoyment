class Solution {
    public void moveZeroes(int[] nums) {
        int i = -1;

        for(int k = 0; k < nums.length; ++k) {
            if(nums[k] == 0) {
                i = k; // 0 index
                break;
            }
        }

        // in case of no zeroes return from here
        if(i == -1) return;

        int j = i + 1; // keep j ahead of i
        while(j < nums.length) {
            if(nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
                i++;
            } else {
                j++;
            }
        }
    }
}