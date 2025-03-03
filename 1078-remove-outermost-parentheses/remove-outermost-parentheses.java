class Solution {
    public String removeOuterParentheses(String s) {

        int count = 0; // Balance tracker
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                if (count > 0) { // Ignore the outermost '('
                    sb.append(s.charAt(i));
                }
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count > 0) { // Ignore the outermost ')'
                    sb.append(s.charAt(i));
                }
            }
        }

        return sb.toString();

    }
}