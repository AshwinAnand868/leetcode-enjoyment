class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int len = 0;
        int result = 0;

        stack.push(-1);

        if(s.length() <= 1) return 0;

        for(int i = 0; i < s.length(); ++i) {
            char curr = s.charAt(i);

            if (curr == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(i - stack.peek(), result);
                }
            }
            

        }

        return result;
    }
}