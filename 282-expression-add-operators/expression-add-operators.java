class Solution {

    public void backtrack(String num, List<String> result, int target, int idx, long runningCal, long lastOperand, StringBuilder sb) {
        if (idx == num.length()) {
            if (runningCal == target) {
                result.add(sb.toString());
            }
            return;
        }

        int len = sb.length();

        for (int i = idx; i < num.length(); ++i) {
            // Corrected: Checking leading zeros in the current number
            if (i != idx && num.charAt(idx) == '0') break; // skip numbers with leading zeroes, except for '0' itself

            String str = num.substring(idx, i + 1);
            long currValue = Long.parseLong(str);

            if (idx == 0) {
                sb.append(str);
                backtrack(num, result, target, i + 1, currValue, currValue, sb);
                sb.setLength(len); // Reset string builder after recursion
            } else {
                // Addition case
                sb.append('+').append(str);
                backtrack(num, result, target, i + 1, runningCal + currValue, currValue, sb);
                sb.setLength(len); // Reset string builder after recursion

                // Subtraction case
                sb.append('-').append(str);
                backtrack(num, result, target, i + 1, runningCal - currValue, -currValue, sb);
                sb.setLength(len); // Reset string builder after recursion

                // Multiplication case
                sb.append('*').append(str);
                backtrack(num, result, target, i + 1, runningCal - lastOperand + lastOperand * currValue, lastOperand * currValue, sb);
                sb.setLength(len); // Reset string builder after recursion
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        // Start the recursion from index 0 with an empty expression
        backtrack(num, result, target, 0, 0, 0, new StringBuilder());

        return result;
    }
}
