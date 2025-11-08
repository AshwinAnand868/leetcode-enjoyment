class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        /*
             0 to low - 1 will contain 0
             low to mid - 1 will contain 1
             mid to high unsorted space
             high + 1 to n - 1 will contain 2
        */

        while(mid <= high) { // until we have unsorted area left
            if(nums[mid] == 0) {
                // swap arr mid with arr low
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }

    }
}