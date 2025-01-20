class Solution {
    public void moveZeroes(int[] nums) {
        // Revision 1
        int n = nums.length;
        int i = -1;

        for(int k = 0; k < n; ++k) {
            if(nums[k] == 0) {
                i = k;
                break;
            }
        }

        if(i == -1) {
            return;
        }

        for(int j = i + 1; j < n; ++j) {
            if(nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                ++i;
            }
        }














        // int n = nums.length;
        // int j = -1;

        // for (int i = 0; i < n; ++i) {
        //     if (nums[i] == 0) {
        //         j = i;
        //         break;
        //     }
        // }

        // if (j == -1) {
        //     return;
        // }

        // for (int i = j + 1; i < n; ++i) {
        //     if (nums[i] != 0) {
        //         int temp = nums[i];
        //         nums[i] = nums[j]; // a[j] will point to zero always
        //         nums[j] = temp;
        //         j++; // move j to next zero
        //     }
        // }
    }
}