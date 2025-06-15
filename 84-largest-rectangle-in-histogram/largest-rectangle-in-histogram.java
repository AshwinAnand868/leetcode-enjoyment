class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftSmall[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear(); // reuse for rightSmall

        // Compute rightSmall[i]
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >=  heights[i]) {
                stack.pop();
            }
            rightSmall[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightSmall[i] - leftSmall[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}

// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         int maxArea = Integer.MIN_VALUE;

//         for(int i = 0; i < n; ++i) {
//             int area = 0;
//             int width = 1;
//             if(i == 0) {
//                 // explore whole right hand side
//                 for(int j = 1; j < n; ++j) {
//                     if(heights[j] >= heights[0]) {
//                         width++;
//                     } else {
//                         break;
//                     }
//                 }
//                 area = width * heights[0];
//             } else if(i == n - 1) {
//                 // explore whole left hand side
//                 for(int j = n - 2; j >= 0; --j) {
//                     if(heights[n - 1] <= heights[j]) {
//                         width++;
//                     } else {
//                         break;
//                     }
//                 }
//                 area = width * heights[n - 1];
//             } else {
//                 // explore whole right hand side
//                 for(int j = i + 1; j < n; ++j) {
//                     if(heights[j] >= heights[i]) {
//                         width++;
//                     } else {
//                         break;
//                     }
//                 }

//                 // explore left hand side
//                 for(int j = i - 1; j >= 0; --j) {
//                     if(heights[j] >= heights[i]) {
//                         width++;
//                     } else {
//                         break;
//                     }
//                 }

//                 area = width * heights[i];
//             }

//             maxArea = Math.max(area, maxArea);
//         }

//         return maxArea;
//     }
// }