class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> treeMap = new TreeMap<>((a, b) -> Integer.compare(b, a));
        int n = names.length;
        for(int i = 0; i < n; ++i) {
            treeMap.put(heights[i], names[i]);
        }

        return treeMap.values().toArray(new String[n]);
    }
}