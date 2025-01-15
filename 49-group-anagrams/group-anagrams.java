class Solution {

    private String generate(String input) {
        int[] counts = new int[26];

        for (char ch : input.toCharArray()) {
            counts[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; ++i) {
            int freq = counts[i];

            if (freq > 0) {
                sb.append(String.valueOf((char) i + 'a').repeat(freq));
            }
        }

        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;
        Map<String, List<String>> sortedToAnagrams = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            String temp = strs[i];

            String newWord = generate(temp);

            if (sortedToAnagrams.containsKey(newWord)) {
                sortedToAnagrams.get(newWord).add(temp);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(temp);
                sortedToAnagrams.put(newWord, tempList);
            }
        }

        // for (int i = 0; i < n; ++i) {
        // String temp = strs[i];

        // char[] tempCharArray = temp.toCharArray();

        // Arrays.sort(tempCharArray);

        // String sorted = String.valueOf(tempCharArray);

        // if (sortedToAnagrams.containsKey(sorted)) {
        // sortedToAnagrams.get(sorted).add(temp);
        // } else {
        // List<String> tempList = new ArrayList<>();
        // tempList.add(temp);
        // sortedToAnagrams.put(sorted, tempList);
        // }
        // }

        for (List<String> list : sortedToAnagrams.values()) {
            result.add(list);
        }

        return result;
    }
}