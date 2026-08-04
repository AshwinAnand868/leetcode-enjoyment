class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        long sum = 0, maxSum = 0;

        Set<Integer> set = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            int curr = nums[right];

            while (set.contains(curr) || right - left + 1 > k) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            sum += curr;
            set.add(curr);

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}