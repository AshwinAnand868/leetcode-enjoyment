class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        int i = 0, j = 0, longLen = 0, n = s.length();

        while(j < n) {
            char ch = s.charAt(j);
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);

            while(charFreq.get(ch) > 1) {
                char chi = s.charAt(i);
                charFreq.put(chi, charFreq.get(chi) - 1);

                if(charFreq.get(chi) <= 0) {
                    charFreq.remove(chi);
                }

                i++;
            }
            longLen = Math.max(longLen, j - i + 1);
            ++j;
        }

        return longLen;
    }
}