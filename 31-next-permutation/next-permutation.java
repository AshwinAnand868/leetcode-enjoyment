class Solution {

    private int[] reverseArray(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }

        return nums;
    }

    public void nextPermutation(int[] nums) {
        int idx = -1;
        
        for(int i = nums.length - 2; i >= 0; --i) {
            if(nums[i] < nums[i + 1]) {
                idx = i; // diping point (breakpoint)
                break;
            }
        }

        if(idx == -1) { // reverse the array as this is the last sequence of the lexicographical order
            reverseArray(nums, 0, nums.length - 1);
            return;
        }

        // finding the next lexicographical permutation

        for(int i = nums.length - 1; i > idx; --i) {
            if(nums[i] > nums[idx]) {
                int t = nums[i];
                nums[i] = nums[idx];
                nums[idx] = t;
                break;
            }
        }

        reverseArray(nums, idx + 1, nums.length - 1);

    }
}