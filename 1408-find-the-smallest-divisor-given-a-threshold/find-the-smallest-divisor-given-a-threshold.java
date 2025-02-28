class Solution {

    public int getMax(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        return maxi;
    }

    public int getDivisionResult(int[] nums, int divisor) {
        int divisionResult = 0;

        for(int i = 0; i < nums.length; ++i) {
            divisionResult += Math.ceil((double)nums[i] / divisor);
        }

        return divisionResult;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length > threshold) return -1;

        int low = 1;
        int high = getMax(nums);

        while(low <= high) {
            int mid = (low + high) / 2;
            int divisionResult = getDivisionResult(nums, mid);

            if(divisionResult > threshold) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}