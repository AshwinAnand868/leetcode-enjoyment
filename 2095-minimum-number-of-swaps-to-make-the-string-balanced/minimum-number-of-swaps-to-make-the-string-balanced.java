class Solution {
    public int minSwaps(String s) {
        // Stack<Character> stack = new Stack<>();
        int count = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '[') {
                // stack.push(ch);
                count++;
            } else if(count > 0) {
                count--;
                // stack.pop();
            }
        }

        int result = (count + 1) / 2; // adding 1 for odd numbers

        return result;
    }
}