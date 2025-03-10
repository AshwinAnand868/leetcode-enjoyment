class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if(s == null || s.length() == 0 || maxLetters == 0) {
            return 0;
        }

        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();
        int max = 0;

        for(int i = 0; i <= n - minSize; ++i) {
            String curr = s.substring(i, i + minSize);
            if(checkIfValid(curr, maxLetters, maxSize)) {
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                max = Math.max(max, map.get(curr));
            }
        }

        return max;
    }

    private boolean checkIfValid(String curr, int maxLetters, int maxSize) {
        HashSet<Character> set = new HashSet<>();

        for(char c: curr.toCharArray()) set.add(c);

        return set.size() <= maxLetters;
    }
}