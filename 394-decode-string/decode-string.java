class Solution {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder temp = new StringBuilder();
        int k = 0;

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if(c == '[') {
                numberStack.push(k);
                stringStack.push(temp);
                temp = new StringBuilder();
                k = 0;
            } else if(c == ']') {
                int count = numberStack.pop();
                StringBuilder decoded = stringStack.pop();
                decoded.append(temp.toString().repeat(count));
                temp = decoded;
            } else {
                // for letters directly
                temp.append(c);
            }
        }

        return temp.toString();
    }
}