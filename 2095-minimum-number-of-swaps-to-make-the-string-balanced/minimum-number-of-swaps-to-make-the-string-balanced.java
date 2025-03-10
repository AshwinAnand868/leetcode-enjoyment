class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '[') {
                stack.push(ch);
            } else if(!stack.isEmpty()) {
                stack.pop();
            }
        }

        int result = (stack.size() + 1) / 2; // adding 1 for odd numbers

        return result;
    }
}