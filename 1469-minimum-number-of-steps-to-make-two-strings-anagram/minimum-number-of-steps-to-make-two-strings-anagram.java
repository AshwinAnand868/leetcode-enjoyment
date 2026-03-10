class Solution {
    public int minSteps(String s1, String s2) {        
        Map<Character, Integer> charFreqMap = new HashMap<>();
        
        for(int i = 0; i < s1.length(); ++i) {
            char ch = s1.charAt(i);
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }
        
        for(int i = 0; i < s2.length(); ++i) {
            char ch = s2.charAt(i);
            if(charFreqMap.containsKey(ch) && charFreqMap.get(ch) > 0) {
                charFreqMap.put(ch, charFreqMap.get(ch) - 1);
            }
        }
        
        int count = 0;
        for (int freq : charFreqMap.values()) {
            count += freq;
        }

        return count;
    }
}