class Solution {
    public int[] getLeftMaxArray(int[] height) {
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];

        for (int i = 1; i < leftMax.length; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        return leftMax;
    }

    public int[] getRightMaxArray(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        return rightMax;
    }

    public int trap(int[] height) {
        int[] leftMost = getLeftMaxArray(height);
        int[] rightMost = getRightMaxArray(height);
        int sum = 0;

        for (int i = 0; i < height.length; ++i) {
            int width = 1;
            int h = Math.min(leftMost[i], rightMost[i]) - height[i];

            int area = width * h;
            sum += area;
        }

        return sum;
    }
}