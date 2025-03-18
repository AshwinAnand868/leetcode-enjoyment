class Solution {
    public int firstUniqChar(String s) {
        Map<Character, int[]> charMap = new HashMap<>(); // Character → [index, frequency]

        // Step 1: Populate the HashMap
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charMap.containsKey(c)) {
                charMap.put(c, new int[]{i, 1}); // Store first index and frequency
            } else {
                charMap.get(c)[1]++; // Increment frequency
            }
        }

        // Step 2: Find the minimum index where frequency is 1
        int minIndex = Integer.MAX_VALUE;
        for (int[] value : charMap.values()) {
            if (value[1] == 1) { // If frequency == 1
                minIndex = Math.min(minIndex, value[0]); // Update minIndex
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
}