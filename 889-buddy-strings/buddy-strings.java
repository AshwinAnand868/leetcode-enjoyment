class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        // Case 1: When both strings are already equal, we can
        // check if they have two same characters that could be swapped
        if(s.equals(goal)) {
            int[] freq = new int[26];
            for(char ch : s.toCharArray()) {
                freq[ch - 'a']++;
                if(freq[ch - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }

        // Case II for finding two mismatched characters
        int j = 0;
        int m = s.length();
        int n = goal.length();
        int unmatchedCharacterCount = 0;
        char[] sUnmatchedChars = new char[2];
        char[] goalUnmatchedChars = new char[2];

        for(int i = 0; i < n; ++i) {
            if(s.charAt(i) != goal.charAt(i)) {
                unmatchedCharacterCount++;

                if(unmatchedCharacterCount > 2) {
                    return false;
                }

                sUnmatchedChars[j] = s.charAt(i);
                goalUnmatchedChars[j] = goal.charAt(i);
                j++;
            }
        }

        if(sUnmatchedChars[0] == goalUnmatchedChars[1] && sUnmatchedChars[1] == goalUnmatchedChars[0]) {
            return true;
        }
        return false;
    }
}