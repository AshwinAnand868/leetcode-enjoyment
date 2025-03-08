class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); ++i) {
            char curr = s.charAt(i);

            if(!stack.isEmpty() && stack.peek() == '(' && curr == ')') {
                stack.pop(); // remov the pair
            } else {
                stack.push(curr);
            }
        }

        return stack.size();
    }
}