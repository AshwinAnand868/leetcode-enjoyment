class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.length() == 1) return false;

        for(int i = 0; i < s.length(); ++i) {
            char curr = s.charAt(i);

            if(curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
            } else if(!stack.isEmpty()) {
                if(curr == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if(curr == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if(curr == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        if(stack.size() > 0) return false;

        return true;
    }
}