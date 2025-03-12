class Solution {

    private void helper(List<String> result, String s, int n, int start, String temp) {
        if(start == n) {
            result.add(temp);
            return;
        }

        // for(int i = start; i < n; ++i) {
            char ch = s.charAt(start);
            if(Character.isDigit(ch)) {
                temp = temp + ch;
                helper(result, s, n, start + 1, temp);
            } else {
                temp = temp + ch;
                helper(result, s, n, start + 1, temp);
                temp = temp.substring(0, temp.length() - 1);
                temp = temp + switchCase(ch);
                helper(result, s, n, start + 1, temp);
            }
        // }
    }

    private char switchCase(char ch) {
        if(Character.isUpperCase(ch)) return Character.toLowerCase(ch);
        return Character.toUpperCase(ch);
    }

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(result, s, s.length(), 0, "");
        return result;
    }
}