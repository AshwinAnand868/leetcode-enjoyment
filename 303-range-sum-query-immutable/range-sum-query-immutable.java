class NumArray {

    private int[] nums;
    private int[] prefixSums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.prefixSums = new int[nums.length];
        this.prefixSums[0] = nums[0];

        for(int i = 1; i < nums.length; ++i) {
            prefixSums[i] = nums[i] + prefixSums[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left - 1 >= 0) {
            return prefixSums[right] - prefixSums[left - 1];
        } else {
            return prefixSums[right];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */