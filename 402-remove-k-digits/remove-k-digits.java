class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();

        for(char ch : num.toCharArray()) {
            while(stack.length() > 0 && stack.charAt(stack.length() - 1) > ch && k > 0) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(ch);
        }

        // remove from end if number is in increasing order
        while(k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        int i = 0;
        while (i < stack.length() && stack.charAt(i) == '0') {
            i++;
        }

        String result = stack.substring(i);

        return result.isEmpty() ? "0" : result;
    }
}