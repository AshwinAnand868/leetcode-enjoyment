class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, maxFreq = 0, maxLen = 0;
        int[] count = new int[26];
        int n = s.length();

        while(j < n) {
            
            count[s.charAt(j) - 'A']++;
            maxFreq = Math.max(count[s.charAt(j) - 'A'], maxFreq);

            while((j - i + 1) - maxFreq > k) {
                count[s.charAt(i) - 'A']--;
                for(int l = 0; l < 26; ++l) {
                    maxFreq = Math.max(count[l], maxFreq);
                }
                ++i;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            ++j;
        }

        return maxLen;
    }
}