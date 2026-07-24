class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;

        int n = height.length;

        for(int i = 0; i < n; ++i) {
            while(!stack.empty() && height[i] >= height[stack.peek()]) {
                
                int bottom = stack.pop();

                if(stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int right = i;

                int width = right - left - 1;
                int h = Math.min(height[left], height[right]) - height[bottom];

                water += width * h;
            }

            stack.push(i);
        }

        return water;
    }
}