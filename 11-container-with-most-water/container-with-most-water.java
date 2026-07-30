class Solution {
    public int maxArea(int[] height) {
        // two pointer approach

        int n = height.length;

        int left = 0;
        int right = n - 1;

        int maxAreaCalc = Integer.MIN_VALUE;

        while(left < right) {
            int width = right - left;
            int commonHeight = Math.min(height[left], height[right]);

            maxAreaCalc = Math.max(maxAreaCalc, commonHeight * width); 

            if(height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxAreaCalc;
    }
}