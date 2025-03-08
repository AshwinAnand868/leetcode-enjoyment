class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int score = 0;
        char[] chars = s.toCharArray();

        for(char c : chars) {
            if(c == '(') {
                stack.push(score); // push the current score onto the stack
                score = 0; // reset score when new opening bracket encountered
            } else {
                score = stack.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }
}