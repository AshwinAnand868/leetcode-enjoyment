class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        int maxA = Integer.MIN_VALUE;

        for(int i = 0; i <= n; ++i) {
            while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                int heightIdx = stack.pop();
                int height = heights[heightIdx];

                int width = 0;
                if(stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxA = Math.max(maxA, height * width);
            }
            stack.push(i);
        }

        return maxA;
    }
}