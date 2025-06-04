class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m + 1]; // length will be equal to second string/word length
        
        for(int i = 0; i <= m; ++i) {
            prev[i] = i;
        }

        for(int i = 1; i <= n; ++i) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for(int j = 1; j <= m; ++j) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(curr[j - 1], Math.min(prev[j - 1], prev[j]));
                }
            }

            prev = curr;
        }

        return prev[m];
    }
}