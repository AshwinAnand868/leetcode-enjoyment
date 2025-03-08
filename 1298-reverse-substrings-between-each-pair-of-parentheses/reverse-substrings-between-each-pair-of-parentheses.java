class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); ++i) {
            char curr = s.charAt(i);

            if(curr == '(') {
                stack.push(res.length());
            } else if(curr == ')') {
                int start = stack.pop();
                reverse(res, start, res.length() - 1);
            } else {
                res.append(curr);
            }
        }

        return res.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while(start < end) {

            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);

            start++;
            end--;
        }
    }
}