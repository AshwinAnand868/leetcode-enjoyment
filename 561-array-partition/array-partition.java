class Solution {
    public int arrayPairSum(int[] nums) {

        int[] exists = new int[20001];
        int maxSum = 0;
        boolean odd = true;

        for (int i = 0; i < nums.length; ++i) {
            exists[nums[i] + 10000]++;
        }

        for (int i = 0; i < exists.length; ++i) {
            while (exists[i] > 0) {
                if (odd) {
                    maxSum += i - 10000;
                }
                odd = !odd; // toggle to select odds only
                exists[i]--; // decrementing the value
            }
        }

        return maxSum;
        // Arrays.sort(nums);

        // int maxSum = 0;

        // for(int i = 0; i < nums.length - 1; i+=2) {
        // maxSum += nums[i];
        // }

        // return maxSum;
    }
}