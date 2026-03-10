class Solution {

    public int area(int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        int n = histogram.length;
        int maxA = 0;

        for(int i = 0; i <= n; ++i) {
            while(!stack.isEmpty() && (i == n || histogram[stack.peek()] >= histogram[i])) {
                int heightIdx = stack.pop();
                int height = histogram[heightIdx];
                
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

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length; // # rows
        int m = matrix[0].length; // # cols

        int[] heights = new int[m]; // initially all heigths are 0
        int maxA = 0;

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(matrix[i][j] == '1') {
                    heights[j]++; 
                } else {
                    heights[j] = 0;
                }
            }

            int cArea = area(heights);
            maxA = Math.max(cArea, maxA);
        }

        return maxA;
    }
}