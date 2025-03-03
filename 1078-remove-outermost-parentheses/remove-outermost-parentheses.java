class Solution {
    public String removeOuterParentheses(String s) {
        int balance = 0; 
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ')') balance--;
            if (balance > 0) sb.append(c);
            if (c == '(') balance++;
        }

        return sb.toString();

    }
}