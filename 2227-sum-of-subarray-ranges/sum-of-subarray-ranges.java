class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int min = nums[i];
                int max = nums[i];

                for (int k = i; k <= j; k++) {
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                }

                sum += (max - min);
            }
        }

        return sum;
    }
}