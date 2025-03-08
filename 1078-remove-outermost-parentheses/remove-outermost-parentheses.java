class Solution {
    public String removeOuterParentheses(String s) {

        int openedBrackets = 0; // Balance tracker
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                if (openedBrackets > 0) { // Ignore the outermost '('
                    sb.append(s.charAt(i));
                }
                openedBrackets++;
            } else {
               if(openedBrackets > 1) {
                    sb.append(s.charAt(i));
               }
               openedBrackets--;
            }
        }

        return sb.toString();

    }
}