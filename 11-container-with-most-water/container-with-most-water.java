class Solution {
    public int maxArea(int[] height) {

        int begin = 0;
        int end = height.length - 1;
        int maxArea = 0;
        int minH = -1;

        while(begin < end) {
            minH = Math.min(height[begin], height[end]);
            int area = minH * (end - begin);

            maxArea = Math.max(maxArea, area);

            while(begin < end && height[begin] <= minH) {
                begin++;
            }

            while(begin < end && height[end] <= minH) {
                end--;
            }
        }

        // int n = height.length;
        // int i = 0;
        // int j = n - 1;
        // int maxArea = 0;

        // while(i < j) {
        //     int w = j - i;
        //     int h = Math.min(height[i], height[j]);

        //     int area = w * h;

        //     maxArea = Math.max(maxArea, area);

        //     if(height[j] <= height[i]) {
        //         j--;
        //     } else {
        //         i++;
        //     }
        // }

        return maxArea;
    }
}