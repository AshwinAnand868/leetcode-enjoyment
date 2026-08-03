class Solution {
    public int countGoodSubstrings(String s) {
        int left = 0;
        int ans = 0;

        Set<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            while (right - left + 1 > 3) {
                set.remove(s.charAt(left));
                left++;
            }

            if (right - left + 1 == 3) {
                ans++;
            }
        }

        return ans;
    }
}