class Solution {
    public int removeElement(int[] nums, int val) {
        int j = -1;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            if (nums[i] == val) {
                j = i;
                break;
            }
        }

        if (j == -1) {
            return n;
        }

        // j index is point to "val" at the starting
        int i = j + 1;
        while (i < n) {
            if (nums[i] == val) {
                ++i;
            } else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                ++j;
            }
        }

        return j;

    }
}