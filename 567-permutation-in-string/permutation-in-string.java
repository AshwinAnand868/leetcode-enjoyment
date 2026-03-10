class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freqS1 = new int[26];
        int[] freqWindow = new int[26];

        for (char c : s1.toCharArray()) {
            freqS1[c - 'a']++;
        }

        int windowSize = s1.length();

        int i = 0, j = 0;
        int n = s2.length();

        while(j < n) {

            char chj = s2.charAt(j);
            freqWindow[chj - 'a']++;

            if((j - i + 1) > windowSize) {
                freqWindow[s2.charAt(i) - 'a']--;
                i++;
            }

            if(Arrays.equals(freqS1, freqWindow)) {
                return true;
            }
            j++;
        }
        
        return false;
    }
}