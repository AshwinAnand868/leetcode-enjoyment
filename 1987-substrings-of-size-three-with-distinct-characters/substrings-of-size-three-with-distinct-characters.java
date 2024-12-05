class Solution {
        public int countGoodSubstrings(String s) {

        int nGoodSubstrings = 0;
        char[] cArr = s.toCharArray();
        List<Character> list = new ArrayList<>();
        Set<Character> charSet = new HashSet<>();

        int k = 3; // length of a good string

        for (int i = 0; i < cArr.length; i++) {

            list.add(cArr[i]);

            if (i >= k - 1) {
                charSet.addAll(list);

                if (charSet.size() == k) {
                    nGoodSubstrings++;
                }
                charSet.clear();
                list.remove(0);
            }
        }

        return nGoodSubstrings;
    }
}