class Solution {
    public int minAddToMakeValid(String s) {

        int minClosingBracketsReq = 0;
        int minOpeningBracketsReq = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                minClosingBracketsReq++;
            } else {
                if (minClosingBracketsReq > 0) {
                    minClosingBracketsReq--;
                } else {
                    minOpeningBracketsReq++;
                }
            }
        }

        return minClosingBracketsReq + minOpeningBracketsReq;

        // Using Stack
        // Stack<Character> stack = new Stack<>();
        // for(int i = 0; i < s.length(); ++i) {
        // char curr = s.charAt(i);

        // if(!stack.isEmpty() && stack.peek() == '(' && curr == ')') {
        // stack.pop(); // remov the pair
        // } else {
        // stack.push(curr);
        // }
        // }

        // return stack.size();
    }
}