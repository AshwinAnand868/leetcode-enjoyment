class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n= nums.length;
        long[] prefixes = new long[n];
        prefixes[0] = nums[0];

        for(int i = 1; i < n; ++i) {
            prefixes[i] = prefixes[ i - 1] + nums[i];
        }

        int[] avgs = new int[n];

        for(int i = 0; i < n; ++i) {
            if((i - k < 0) || (i + k >= n)) {
                avgs[i] = -1;
            } else {
                
                int l = i - k;
                int r = i + k;
                long sum = prefixes[r] - (l > 0 ? prefixes[l - 1] : 0);
                avgs[i] = (int) (sum / (2 * k + 1));
            }
        }

        return avgs;

        // int n = nums.length;
        

        // for(int i = 0; i < n; ++i) {
        //     if((i - k < 0) || (i + k >= n)) {
        //         avgs[i] = -1;
        //     } else {
        //         int sum = 0;
        //         for(int j = i - k; j <= i + k; ++j) {
        //             sum += nums[j];
        //         }

        //         avgs[i] = (int) (sum / (2 * k + 1));
        //     }
        // }

        // return avgs;
    }
}