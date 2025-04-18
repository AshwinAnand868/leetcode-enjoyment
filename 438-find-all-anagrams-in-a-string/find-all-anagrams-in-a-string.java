class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int m = p.length();
        int[] pFreq = new int[26];

        for(char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        int i = 0, j = 0;

        while(j < n) {
            pFreq[s.charAt(j) - 'a']--;

            if(j - i + 1 == m) {
                if(allAreZeroes(pFreq)) {
                    result.add(i);
                }

                pFreq[s.charAt(i) - 'a']++;
                i++;
            }
            

            ++j;
        }

        return result;
    }

    private boolean allAreZeroes(int[] count) {
        for(int i : count) {
            if(i != 0) return false;
        }
        
        return true;
    }
}