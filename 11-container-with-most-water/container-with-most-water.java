class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxArea = 0;

        while(i < j) {
            int w = j - i;
            int h = Math.min(height[i], height[j]);

            int area = w * h;

            maxArea = Math.max(maxArea, area);

            if(height[j] <= height[i]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }
}