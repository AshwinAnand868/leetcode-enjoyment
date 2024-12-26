class Solution {
    public int removeDuplicates(int[] nums) {
        // two pointers approach
        int i = 0;
        int j = 1;
        int n = nums.length;
        int k = n;

        if (n == 1) {
            return 1;
        }

        while (j < n) {
            if (nums[i] == nums[j]) {
                ++j;
            } else if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                ++i;
            }
        }

        k = i + 1;

        return k;
    }
}