class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftArray = new int[n];
        int[] rightArray = new int[n];

        int totalFromLeft = 0;
        int totalFromRight = 0;
        for(int i = 0; i < n; ++i) {
            totalFromLeft += nums[i];
            leftArray[i] = totalFromLeft;
        }

        for(int i = n - 1; i >= 0; i--) {
            totalFromRight += nums[i];
            rightArray[i] = totalFromRight;
        }

        for(int i = 0; i < n; ++i) {
            if(leftArray[i] == rightArray[i]) {
                return i;
            }
        }

        return -1;
    }
}