class Solution {

    public boolean backtrack(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null) return memo[start];

        for (int end = start + 1; end <= s.length(); ++end) {
            String prefix = s.substring(start, end);
            if (wordDict.contains(prefix) && backtrack(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return backtrack(s, wordSet, 0, memo);
    }
}