class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] prev = new int[m + 1];
        prev[0] = 1; // base case: empty t is a subsequence of any s

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = 1; // empty t is always a subsequence

            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                }
                curr[j] += prev[j];
            }

            prev = curr; // move to the next row
        }

        return prev[m];
    }
}
