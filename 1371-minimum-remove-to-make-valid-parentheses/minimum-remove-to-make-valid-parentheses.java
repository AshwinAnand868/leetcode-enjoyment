class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> openingBrackets = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); ++i) {
            char ch = sb.charAt(i);

            if (ch == '(') {
                openingBrackets.push(i);
            } else if (ch == ')') {
                if (openingBrackets.isEmpty()) {
                    sb.deleteCharAt(i);
                    i--;
                } else {
                    openingBrackets.pop();
                }
            }
        }

        while (openingBrackets.size() > 0) {
            sb.deleteCharAt(openingBrackets.pop());
        }

        return sb.toString();
    }
}