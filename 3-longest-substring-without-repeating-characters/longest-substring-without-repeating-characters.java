class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        int maxLength = 0;
        
        for(int i = 0; i < s.length(); ++i) {
            StringBuilder sbr = new StringBuilder();
            
            for(int j = i; j < s.length(); ++j) {
                if(sbr.length() == 0 || !sbr.toString().contains(String.valueOf(s.charAt(j)))) {
                    sbr.append(s.charAt(j));
                    String str = sbr.toString();
                    map.put(str, map.getOrDefault(str, 0) + 1);
                } else {
                    break;
                }
            }
        }
        
        for(String key: map.keySet()) {
            maxLength = Math.max(maxLength, key.length());
        }
        
        return maxLength; 
    }
}