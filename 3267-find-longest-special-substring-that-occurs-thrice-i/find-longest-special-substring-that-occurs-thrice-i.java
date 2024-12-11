class Solution {
    public int maximumLength(String s) {
        
        Map<String, Integer> map = new HashMap<>();
        int maxLength = -1;
        
        // storing special strings and their frequency in the array
        for(int i = 0; i < s.length(); ++i) {
            StringBuilder cunS = new StringBuilder();
            
            for(int j = i; j < s.length(); ++j) {
                if(cunS.length() == 0 || s.charAt(j) == cunS.charAt(cunS.length() - 1)) {
                    cunS.append(s.charAt(j));
                    String str = cunS.toString();
                    map.put(str, map.getOrDefault(str, 0) + 1);
                } else {
                    break;
                }
            }
        }
        
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            
            // frequency of the special substring is > 2
            if(val > 2) {
                maxLength = Math.max(maxLength, key.length());
            }
        }
        
        return maxLength;
        
//         Map<Map.Entry<Character, Integer>, Integer> map = new HashMap<>();
//         int count;
            
//         for(int i = 0; i < s.length(); i++) {
//             count = 1;
//             map.put(Map.entry(s.charAt(i), count), map.getOrDefault(Map.entry(s.charAt(i), count), 0) + 1);
            
//             for(int j = i; j < s.length(); j++) {
//                 if(j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
//                     count++;
//                     map.put(Map.entry(s.charAt(i), count), map.getOrDefault(Map.entry(s.charAt(i), count), 0) + 1);
//                 } else {
//                     break; // if same character substring is finished
//                 }
//             }
//         }
        
//         int result = -1;
        
//                 for(Map.Entry<Map.Entry<Character, Integer>, Integer> entry: map.entrySet()) {
//                     if(entry.getValue() >= 3) {
//                         result = Math.max(entry.getKey().getValue(), result);
//                     }
//                 }
        
        
//         return result;
    }
}