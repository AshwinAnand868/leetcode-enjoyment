class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        if(k == 0) {
            return nums;
        }

        int[] avgs = new int[n];
        Arrays.fill(avgs, -1);

        if(n < 2 * k + 1) {
            return avgs;
        }

        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        for(int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for(int i = k; i < n - k; ++i) {
            int left = i - k;
            int right = i + k;

            long sum = prefixSum[right];

            if(left > 0) {
                sum = sum - prefixSum[left - 1];
            }

            avgs[i] = (int) (sum / (2 * k + 1));
        }

        return avgs;
    }
}