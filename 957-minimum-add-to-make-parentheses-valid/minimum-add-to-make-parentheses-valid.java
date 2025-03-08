class Solution {
    public int minAddToMakeValid(String s) {

        int openingBracket = 0;
        int minAddRequired = 0;

        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                openingBracket++;
            } else {
                if(openingBracket > 0) {
                    openingBracket--;
                } else {
                    minAddRequired++;
                }
            }
        }

        return minAddRequired + openingBracket;

        // Using Stack
        // Stack<Character> stack = new Stack<>();
        // for(int i = 0; i < s.length(); ++i) {
        //     char curr = s.charAt(i);

        //     if(!stack.isEmpty() && stack.peek() == '(' && curr == ')') {
        //         stack.pop(); // remov the pair
        //     } else {
        //         stack.push(curr);
        //     }
        // }

        // return stack.size();
    }
}