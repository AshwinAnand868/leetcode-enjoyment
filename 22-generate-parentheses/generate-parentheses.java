class Solution {
    public void recursivelyGenerateParenthesis(List<String> result, int open, int close, StringBuilder temp, int n) {
        if((temp.length()/2) == n) {
            result.add(temp.toString());
            return;
        }

        if(open < n) {
            temp.append("(");
            recursivelyGenerateParenthesis(result, open + 1, close, temp, n);
            temp.deleteCharAt(temp.length() - 1);
        }

        if(close < open) {
            temp.append(")");
            recursivelyGenerateParenthesis(result, open, close + 1, temp, n);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {

        if (n == 1) {
            List<String> res = new ArrayList<>();
            res.add("()");
            return res;
        }

        List<String> result = new ArrayList<>();

        recursivelyGenerateParenthesis(result, 0, 0, new StringBuilder(), n);

        return result;
    }
}