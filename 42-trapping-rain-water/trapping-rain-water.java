class Solution {

    public int[] getLeftMostArray(int[] height) {
        int[] leftMost = new int[height.length];
        leftMost[0] = height[0];

        for(int i = 1; i < leftMost.length; ++i) {
            leftMost[i] = Math.max(leftMost[i - 1], height[i]);
        }

        return leftMost;
    }

    public int[] getRightMostArray(int[] height) {
        int n = height.length;
        int[] rightMost = new int[n];
        rightMost[n - 1] = height[n - 1];

        for(int i = n - 2; i >= 0; --i) {
            rightMost[i] = Math.max(rightMost[i + 1], height[i]);
        }

        return rightMost;
    }


    public int trap(int[] height) {
        int[] leftMost = getLeftMostArray(height);
        int[] rightMost = getRightMostArray(height);
        int sum = 0;

        for(int i = 0; i < height.length; ++i) {
            int width = 1;
            int h = Math.min(leftMost[i], rightMost[i]) - height[i];

            int area = width * h;
            sum += area;
        }

        return sum;
    }
}