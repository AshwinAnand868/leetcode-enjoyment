class Solution {

    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    public int longestStrChain(String[] words) {
        Arrays.sort(words, comp);
        int n = words.length;
        int[][] dp = new int[n + 1][n + 1];

        // base cases
        dp[n][n] = 0;

        for(int i = n - 1; i >= 0; --i) {
            for(int prev = n - 1; prev >= -1; --prev) {
                int skip = dp[i + 1][prev + 1];

                int take = 0;
                if(prev == -1 || checkPossible(words[i], words[prev])) {
                    take = 1 + dp[i + 1][i + 1];
                }

                dp[i][prev + 1] = Math.max(take, skip);
            }
        }

        return dp[0][-1 + 1];

        // int[][] memo = new int[n][n + 1];
        // for(int[] row: memo) {
        //     Arrays.fill(row, -1);
        // }
        // return helper(words, 0, -1, memo);
    }

    private boolean checkPossible(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();

    }

    private int helper(String[] words, int index, int prevIndex, int[][] memo) {
        if(index == words.length) {
            return 0;
        }
        
        if(memo[index][prevIndex + 1] != -1) {
            return memo[index][prevIndex + 1];
        }

        // skip
        int skip = helper(words, index + 1, prevIndex, memo);

        // take
        int take = 0;
        if(prevIndex == -1 || checkPossible(words[index], words[prevIndex])) {
            take = 1 + helper(words, index + 1, index, memo);
        }

        return memo[index][prevIndex + 1] = Math.max(take, skip);
    }
}