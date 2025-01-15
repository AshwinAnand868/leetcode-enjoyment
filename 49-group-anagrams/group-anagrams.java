class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;
        Map<String, List<String>> sortedToAnagrams = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            String temp = strs[i];

            char[] tempCharArray = temp.toCharArray();

            Arrays.sort(tempCharArray);

            String sorted = String.valueOf(tempCharArray);

            if (sortedToAnagrams.containsKey(sorted)) {
                sortedToAnagrams.get(sorted).add(temp);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(temp);
                sortedToAnagrams.put(sorted, tempList);
            }
        }

        for (List<String> list : sortedToAnagrams.values()) {
            result.add(list);
        }

        return result;
    }
}