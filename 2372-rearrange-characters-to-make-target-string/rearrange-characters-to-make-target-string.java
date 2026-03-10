class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] countersS = new int[26];  // Frequency of chars in s
        int[] countersT = new int[26];  // Frequency of chars in target
        int copies = Integer.MAX_VALUE;

        // Count occurrences of each letter in s
        for (char c : s.toCharArray()) {
            countersS[c - 'a']++;
        }

        // Count occurrences of each letter in target
        for (char c : target.toCharArray()) {
            countersT[c - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {  // Iterate over all letters 'a' to 'z'
            if (countersT[i] > 0) {  // Only consider letters in target
                copies = Math.min(copies, countersS[i] / countersT[i]);
            }
        }

        return copies;
    }
}
