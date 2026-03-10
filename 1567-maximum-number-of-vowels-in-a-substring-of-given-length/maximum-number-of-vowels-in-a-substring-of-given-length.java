class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');


        int i = 0;
        int j = 0;
        int n = s.length();
        int maxCount = 0, count = 0;

        while(j < n) {
            if(vowels.contains(s.charAt(j))) {
                count++;
            }

            if(j - i + 1 == k) {
                maxCount = Math.max(maxCount, count);

                if(vowels.contains(s.charAt(i))) {
                    count--;
                }

                i++;
            }

            ++j;
        }

        return maxCount;
    }
}