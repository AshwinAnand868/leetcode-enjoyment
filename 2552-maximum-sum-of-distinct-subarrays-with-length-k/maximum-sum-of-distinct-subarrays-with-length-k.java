class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0, n = nums.length;
        long sum = 0, maxSum = 0;

        Set<Integer> set = new HashSet<>();

        for(int right = 0; right < n; ++right) {
            int curr = nums[right];
            int length = right - left + 1;

            // if current element is in set, then we shrink
            while(set.contains(curr)) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
                length = right - left + 1;
            }
            
            sum += curr; // consider current element

            set.add(curr);
           
            while(length > k && left < n) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
                length = right - left + 1;
            }

            if(length == k) {
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}