class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; ++i) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            leftSmall[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();

        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            rightSmall[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int area = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i) {
            int height = heights[i];
            int width = rightSmall[i] - leftSmall[i] - 1;
            area = Math.max(height * width, area);
        }

        return area;
    }
}