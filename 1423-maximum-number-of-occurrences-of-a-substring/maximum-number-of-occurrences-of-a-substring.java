class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int[] counters = new int[26];

        Map<String,Integer> map = new HashMap<>();

        int letters = 0, maxOccur = 0;

        for(int i = 0, j = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            counters[ch - 'a']++;

            if(counters[ch - 'a'] == 1) letters++; // unique chars in current substring

            while(letters > maxLetters || i - j + 1 > maxSize) {
                char charAtj = s.charAt(j);

                counters[charAtj - 'a']--;

                if(counters[charAtj - 'a'] == 0) {
                    letters--;
                }
                j++;
            }

            while(i - j + 1 >= minSize) { // all three conditions are satisfied, we add the substr to map
                String str = s.substring(j, i + 1);
                map.put(str, map.getOrDefault(str, 0) + 1);
                maxOccur = Math.max(maxOccur, map.get(str));

                char charAtj = s.charAt(j);

                counters[charAtj - 'a']--;

                if(counters[charAtj - 'a'] == 0) {
                    letters--;
                }   
                j++;
            }
        }

        return maxOccur;
    }

    //     if(s == null || s.length() == 0 || maxLetters == 0) {
    //         return 0;
    //     }

    //     HashMap<String, Integer> map = new HashMap<>();
    //     int n = s.length();
    //     int max = 0;

    //     for(int i = 0; i <= n - minSize; ++i) {
    //         String curr = s.substring(i, i + minSize);
    //         if(checkIfValid(curr, maxLetters, maxSize)) {
    //             map.put(curr, map.getOrDefault(curr, 0) + 1);
    //             max = Math.max(max, map.get(curr));
    //         }
    //     }

    //     return max;
    // }

    // private boolean checkIfValid(String curr, int maxLetters, int maxSize) {
    //     HashSet<Character> set = new HashSet<>();

    //     for(char c: curr.toCharArray()) set.add(c);

    //     return set.size() <= maxLetters;
    // }
}