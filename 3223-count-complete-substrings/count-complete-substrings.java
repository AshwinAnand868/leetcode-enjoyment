class Solution {

    public int solve(int start, int end, String word, int k) {
        int result = 0;

        // considering unique chars from 1 to 26 or upto maximum substring length
        for(int uniqueChars = 1; uniqueChars <= 26 && uniqueChars * k <= end - start + 1; uniqueChars++) {
            int[] count = new int[26]; // for lowercase characters count only
            int goodChar = 0;

            int i = start;
            int windowLen = k * uniqueChars; // maximum curr window length

            for(int j = start; j <= end; ++j) {
                char ch = word.charAt(j);

                count[ch - 'a']++;

                if(count[ch - 'a'] == k) {
                    goodChar++;
                } else if(count[ch - 'a'] == k + 1) {
                    goodChar--;
                }

                // if curr window exceeds max curr window len
                if(j - i + 1 > windowLen) {
                    char chi = word.charAt(i);
                    if(count[chi - 'a'] == k) { // we decrement good char if curr char at i equal to k, because we are gonna decrease the frequency of this char or remove it from window
                        goodChar--;
                    } else if(count[chi - 'a'] == k + 1) {
                        goodChar++;
                    }
                    count[chi - 'a']--;
                    i++;
                }

                if(goodChar == uniqueChars) {
                    result++;
                }
            }

        }

        return result;
    }

    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int last = 0;
        int result = 0;

        for(int i = 1; i <= n; ++i) {
            // borders like "aa" | "ddff" | "kk"
            if(i == n || Math.abs(word.charAt(i) - word.charAt(i - 1)) > 2) {
                result += solve(last, i - 1, word, k);
                last = i;
            }
        }

        return result;
    }
}