class Solution {

    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int resultIndex = 0;
        int count = 1;

        for (int i = 0; i < this.nums.length; ++i) {
            if (nums[i] == target) {

                if (Math.random() < 1.0 / count) {
                    resultIndex = i;
                }

                count++;
            }
        }

        return resultIndex;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */