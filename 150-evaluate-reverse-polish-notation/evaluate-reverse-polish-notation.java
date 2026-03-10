class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> tokenStack = new Stack<>();
        int result = 0;

        if(tokens.length < 2) return Integer.parseInt(tokens[0]);

        for (String token : tokens) {
            switch (token) {
                case "+":
                    int firstOperandPlus = Integer.valueOf(tokenStack.pop());
                    int secondOperandPlus = Integer.valueOf(tokenStack.pop());
                    result = (secondOperandPlus + firstOperandPlus); // second operand on left and other on right side
                    tokenStack.push(Integer.toString(result));
                    break;

                case "*":
                    int firstOperandMul = Integer.valueOf(tokenStack.pop());
                    int secondOperandMul = Integer.valueOf(tokenStack.pop());
                    result = (secondOperandMul * firstOperandMul);
                    tokenStack.push(Integer.toString(result));
                    break;

                case "/":
                    int firstOperandDiv = Integer.valueOf(tokenStack.pop());
                    int secondOperandDiv = Integer.valueOf(tokenStack.pop());
                    result = (secondOperandDiv / firstOperandDiv);
                    tokenStack.push(Integer.toString(result));
                    break;

                case "-":
                    int firstOperandMin = Integer.valueOf(tokenStack.pop());
                    int secondOperandMin = Integer.valueOf(tokenStack.pop());
                    result = (secondOperandMin - firstOperandMin);
                    tokenStack.push(Integer.toString(result));
                    break;

                default:
                    tokenStack.push(token);
            }
        }

        return result;
    }
}