class Solution {
    public String minWindow(String s, String t) {

        if(s == null || t == null || s.length() < t.length()) return "";

        int i = 0, j = 0;
        HashMap<Character, Integer> tMap = new HashMap<>();
        int m = s.length(), n = t.length();

        for(int k = 0; k < n; ++k) {
            tMap.put(t.charAt(k), tMap.getOrDefault(t.charAt(k), 0) + 1);
        }

        int uniqueCount = tMap.size();

        HashMap<Character, Integer> sMap = new HashMap<>();
        int currCount = 0;
        int[] ans = new int[3];
        ans[0] = -1;

        while(j < m) {
            sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
            if (tMap.containsKey(s.charAt(j)) && 
                    sMap.get(s.charAt(j)).intValue() == tMap.get(s.charAt(j)).intValue()) {
                currCount++;
            }

            while(i <= j && currCount == uniqueCount) {
                if(ans[0] == -1 || j - i + 1 < ans[0]) {
                    ans[0] = j - i + 1;
                    ans[1] = i;
                    ans[2] = j;
                }

                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);

                if(tMap.containsKey(s.charAt(i)) && sMap.get(s.charAt(i)) < tMap.get(s.charAt(i))) {
                    currCount--;
                }

                if(sMap.get(s.charAt(i)) <= 0) {
                    sMap.remove(s.charAt(i));
                }

                ++i;
            }

            ++j;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}