class Solution {
    public int maximumLengthSubstring(String s) {
        
        int n = s.length();
        char[] alpha = new char[26];
        int maxLength = 0;
        
        for(int leftPointer = 0, rightPointer = 0; rightPointer < n; rightPointer++) {
            char rightChar = s.charAt(rightPointer);
            alpha[rightChar - 'a']++;
            
            if(alpha[rightChar - 'a'] <= 2) {
                maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
                continue; // skip the next part
            }
            
            while(alpha[rightChar - 'a'] > 2) {
                // we decrement the count at the left most char
                alpha[s.charAt(leftPointer) - 'a']--;
                leftPointer++;
            }
        }
        
        return maxLength;
        
       
        
//         char[] cArr = s.toCharArray();
        
//         int maxLength = 0;
//         Map<Character, Integer> map;
        
//         for(int i = 0; i < cArr.length; ++i) {
//             map = new HashMap<>();
            
//             for(int j = i; j < cArr.length; ++j) {
//                 map.put(cArr[j], map.getOrDefault(cArr[j], 0) + 1);
                
//                 if(map.get(cArr[j]) > 2) {
//                     break;
//                 }
                
//                 maxLength = Math.max(maxLength, j - i + 1);
//             }
            
            
//         }
        
//         return maxLength;
    }
}