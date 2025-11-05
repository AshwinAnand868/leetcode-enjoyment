class Solution {

    public String generateString(String str) {
        int[] count = new int[26];
        int n = str.length();

        for(int i = 0; i < n; ++i) {
            count[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; ++i) {
            int freq = count[i];

            if(freq > 0) {
                sb.append(String.valueOf(i + 'a').repeat(freq));
            }
        }

        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int n = strs.length;

        for(int i = 0; i < n; i++) {
           
            String sortedKey = generateString(strs[i]);

            if(map.containsKey(sortedKey)) {
                map.get(sortedKey).add(strs[i]);
            } else {
                map.put(sortedKey, new ArrayList<>());
                map.get(sortedKey).add(strs[i]);
            }
        }

        return new ArrayList<>(map.values());
    }
}