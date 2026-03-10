class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;

        int left = 0;
        int right = n - 1;

        int maxLeft = 0, maxRight = 0;

        int trapped = 0;

        while(left <= right) {
            if(height[left] <= height[right]) {
                if(height[left] >= maxLeft) {
                    maxLeft = height[left];
                } 
                trapped += maxLeft - height[left];
                left++;
            } else {
                if(height[right] >= maxRight) {
                    maxRight = height[right];
                }
                trapped += maxRight - height[right];
                right--;
            }
        }

        return trapped;
    }
}