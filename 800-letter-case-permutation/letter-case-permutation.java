class Solution {

    private void helper(List<String> result, StringBuilder temp, String s, int n, int start) {
        result.add(temp.toString());  // Store the current combination

        for (int i = start; i < n; i++) {
            char ch = s.charAt(i);

            // Skip digits since they remain unchanged
            if (Character.isLetter(ch)) {
                // Swap case
                temp.setCharAt(i, switchCase(ch));

                // Recur for next index
                helper(result, temp, s, n, i + 1);

                // Backtrack - revert the character to its original state
                temp.setCharAt(i, ch);
            }
        }
    }

    private char switchCase(char ch) {
        return Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
    }

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder(s); // Using StringBuilder for in-place modifications
        helper(result, temp, s, s.length(), 0);
        return result;
    }
}