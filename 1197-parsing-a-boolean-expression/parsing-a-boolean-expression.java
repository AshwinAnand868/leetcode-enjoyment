class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < expression.length(); ++i) {
            if(expression.charAt(i) == ')') {
                List<Character> temp = new ArrayList<>();
                while(stack.peek() != '(') {
                    char cur = stack.pop();
                    if(cur != ',') {
                        temp.add(cur);
                    }
                }
                // get rid of open parenthesis
                stack.pop();

                char operator = stack.pop();
                char ch = temp.get(0);
                boolean res = ch == 't' ? true : false;

                if(operator == '!') {
                    res = !res;
                } else {
                    for(int j = 1; j < temp.size(); ++j) {
                        boolean bool = temp.get(j) == 't' ? true : false;
                        if(operator == '&') {
                            res = res && bool;
                        } else if(operator == '|') {
                            res = res || bool;
                        }
                    }
                }
                
                // push the resultant expression
                if(res) {
                    stack.push('t');
                } else {
                    stack.push('f');
                }
            } else {
                stack.push(expression.charAt(i));
            }
        }

        return stack.pop() == 't' ? true : false; // final evaluated expression
    }
}