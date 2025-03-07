class Solution {
    public int getCurrentStringBeauty(String s) {
        int[] counters = new int[26];
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); ++i) {
            counters[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); ++i) {
            minFreq = Math.min(minFreq, counters[s.charAt(i) - 'a']);
        }

        for (int i = 0; i < s.length(); ++i) {
            maxFreq = Math.max(maxFreq, counters[s.charAt(i) - 'a']);
        }

        return maxFreq - minFreq;
    }

    public int beautySum(String s) {
        int beautySum = 0;

        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                beautySum += getCurrentStringBeauty(s.substring(i, j + 1));
            }
        }

        return beautySum;
    }

}