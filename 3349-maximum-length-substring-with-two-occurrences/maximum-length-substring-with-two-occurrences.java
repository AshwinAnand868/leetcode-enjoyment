class Solution {
    public int maximumLengthSubstring(String s) {
       
        
        char[] cArr = s.toCharArray();
        int k = 2;
        
        int maxLength = 0;
        Map<Character, Integer> map;
        
        for(int i = 0; i < cArr.length; ++i) {
            map = new HashMap<>();
            
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