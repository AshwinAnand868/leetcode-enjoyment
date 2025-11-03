class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int n = strs.length;

        for(int i = 0; i < n; i++) {
            String tempStr = strs[i];
            char[] charArray = tempStr.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            if(map.containsKey(sortedKey)) {
                map.get(sortedKey).add(tempStr);
            } else {
                map.put(sortedKey, new ArrayList<>());
                map.get(sortedKey).add(tempStr);
            }
        }

        return new ArrayList<>(map.values());
    }
}