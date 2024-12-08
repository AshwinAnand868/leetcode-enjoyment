class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        char[] cArr = s.toCharArray();
        int k = 2;
        
        int maxLength = 0;
        
        for(int i = 0; i < cArr.length; ++i) {
            map.clear();
            
            for(int j = i; j < cArr.length; ++j) {
                map.put(cArr[j], map.getOrDefault(cArr[j], 0) + 1);
                
                if(map.get(cArr[j]) > 2) {
                    break;
                }
                
                maxLength = Math.max(maxLength, j - i + 1);
            }
            
            
        }
        
        return maxLength;
    }
}