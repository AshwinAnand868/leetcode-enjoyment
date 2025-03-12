class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        // Two pointers
        int n = s.length();
        int mid = n/2;
        int i = 0, j = mid;
        int leftVowelCount = 0, rightVowelCount = 0;

        while(i < mid && j < n) {

            if(vowels.contains(s.charAt(i))) {
                leftVowelCount++;
            }

            if(vowels.contains(s.charAt(j))) {
                rightVowelCount++;
            }

            ++i;
            ++j;
        }

        return leftVowelCount == rightVowelCount;
    }
}