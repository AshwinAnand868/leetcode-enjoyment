class Solution {

    public boolean isConcatenated(String word, Set<String> st, Map<String, Boolean> map) {
        // memoization for the word that has already been found concantenated or not
        if(map.containsKey(word)) {
            return map.get(word);
        }

        int l = word.length();
        for(int i = 0; i < l; ++i) {
            String prefix = word.substring(0, i + 1);
            String suffix = word.substring(i + 1, l);

            if((st.contains(prefix) && st.contains(suffix)) || (st.contains(prefix) && isConcatenated(suffix, st, map))) {
                map.put(word, true);
                return true;
            }
        }

        map.put(word, false);
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Map<String, Boolean> map = new HashMap<>();

        List<String> result = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            String word = words[i];
            if(isConcatenated(word, set, map)) {
                result.add(word);
            }
        }

        return result;
    }
}