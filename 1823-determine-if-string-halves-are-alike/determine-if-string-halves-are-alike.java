class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int n = s.length();

        int mid = n / 2;
        int aCount = 0;
        int bCount = 0;

        for(int i = 0; i < mid; ++i) {
            if(vowelSet.contains(s.charAt(i))) {
                aCount++;
            }
        }

        for(int i = mid; i < n; ++i) {
            if(vowelSet.contains(s.charAt(i))) {
                bCount++;
            }
        }

        return bCount == aCount;
    }
}