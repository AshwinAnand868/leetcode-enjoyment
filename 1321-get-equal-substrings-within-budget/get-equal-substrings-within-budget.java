class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0;
        int n = s.length();

        int currCost = 0;
        int maxLen = 0;

        while(right < n) {
            currCost += Math.abs(s.charAt(right) - t.charAt(right));

            while(left <= right && currCost > maxCost) {

                currCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}