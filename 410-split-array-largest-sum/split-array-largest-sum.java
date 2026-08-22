class Solution {

    private boolean splitPossible(int[] nums, int k, int potentialSum) {
        int currentSplits = 1;
        int currentSum = 0;

        for(int i = 0; i < nums.length; ++i) {
            if(currentSum + nums[i] > potentialSum) {
                currentSplits++;
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
        }

        return currentSplits <= k ? true : false;
    }

    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        int n = nums.length;
        for(int i = 0; i < n; ++i) {
            high += nums[i];
            low = Math.max(low, nums[i]);
        }

        int ans = low;

        while(low <= high) {
            // mid is the sum we are assuming between low and total sum or high
            int mid = low + (high - low) / 2;

            if(splitPossible(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
}