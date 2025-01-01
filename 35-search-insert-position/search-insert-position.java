class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;

        while(low <= high) // until low doesn't cross high
        {
            if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }

            mid = (low + high) / 2;
        }

        if(nums[mid] < target) {
            return mid + 1;
        } else { // greater than target as equal check is already in the loop
            return mid;
        }


        // while(low <= high) {
        //     int mid = (low + high) / 2;

        //     if(nums[mid] == target){
        //         return mid;
        //     } else if(nums[mid] > target) {
        //         high = mid - 1;
        //     } else {
        //         low = mid + 1;
        //     }
        // }

        // return low;
    }
}