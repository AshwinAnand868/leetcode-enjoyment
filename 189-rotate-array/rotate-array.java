class Solution {

    public void reverse(int start, int end, int[] nums) {
        while(start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;
        reverse(0, n - k - 1, nums);
        reverse(n-k, n-1, nums);
        reverse(0, n-1, nums);
    }
}