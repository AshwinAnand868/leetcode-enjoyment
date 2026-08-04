class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;

        int[] count = new int[26];

        int n = s.length();

        int maxLen = 0;
        int maxFreq = 0;

        for(int j = 0; j < n; ++j) {
            char curr = s.charAt(j);

            // inside the current window increment the count of current character
            count[curr - 'A']++;
            maxFreq = Math.max(maxFreq, count[curr - 'A']);

            // if at any point we have more than k operations character
            while((j - i + 1) - maxFreq > k) {
                // we shift our window
                count[s.charAt(i) - 'A']--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}