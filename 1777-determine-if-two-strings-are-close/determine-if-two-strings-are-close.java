class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int m = word1.length();
        int n = word2.length();

        if(m != n) {
            return false;
        }

        for(int i = 0; i < m; ++i) {
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);

            freq1[char1 - 'a']++;
            freq2[char2 - 'a']++;
        }

        // 1 : Check if both the word 1 and word 2 have the same characters
        for(int i = 0; i < 26; ++i) {
            if((freq1[i] != 0 && freq2[i] != 0) || (freq1[i] == 0 && freq2[i] == 0)) {
                continue;
            }

            return false;
        }


        // 2: Compare the frequencies in both the arrays
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}