class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int i = 1;
        
        for(int j = 1; j < n; ++j) {
            if(nums[j] != nums[j - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
        // // two pointers approach
        // int i = 0; // slow pointer
        // int j = 1; // fast pointer
        // int n = nums.length;
        // int k = n;

        // if (n == 1) {
        //     return 1;
        // }

        // while (j < n) {
        //     if (nums[i] == nums[j]) {
        //         ++j;
        //     } else if (nums[i] != nums[j]) {
        //         nums[i + 1] = nums[j];
        //         ++i; 
        //     }
        // }

        // k = i + 1;

        // return k;   
    }
}