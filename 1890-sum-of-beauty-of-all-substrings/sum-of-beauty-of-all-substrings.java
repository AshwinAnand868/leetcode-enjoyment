
class Solution {

    public int beautySum(String s) {
        int beautySum = 0;

        for (int i = 0; i < s.length(); ++i) {
            int[] freqs = new int[26];
            for (int j = i; j < s.length(); ++j) {
                freqs[s.charAt(j) - 'a']++;
                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;

                for (int k = 0; k < 26; ++k) {
                    if (freqs[k] > 0) {
                        minFreq = Math.min(minFreq, freqs[k]);
                        maxFreq = Math.max(maxFreq, freqs[k]);
                    }
                }
                beautySum += (maxFreq - minFreq);

                // beautySum += getCurrentStringBeauty(s.substring(i, j + 1));
            }
        }

        return beautySum;
    }

    // private int getCurrentStringBeauty(String s) {
    // int[] counters = new int[26];
    // int maxFreq = Integer.MIN_VALUE;
    // int minFreq = Integer.MAX_VALUE;

    // for (int i = 0; i < s.length(); ++i) {
    // counters[s.charAt(i) - 'a']++;
    // }

    // for (int i = 0; i < s.length(); ++i) {
    // minFreq = Math.min(minFreq, counters[s.charAt(i) - 'a']);
    // }

    // for (int i = 0; i < s.length(); ++i) {
    // maxFreq = Math.max(maxFreq, counters[s.charAt(i) - 'a']);
    // }

    // return maxFreq - minFreq;
    // }

}