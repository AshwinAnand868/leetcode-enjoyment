class Solution {
    public int maximumLength(String s) {
        Map<Map.Entry<Character, Integer>, Integer> map = new HashMap<>();
        int count;
            
        for(int i = 0; i < s.length(); i++) {
            count = 1;
            map.put(Map.entry(s.charAt(i), count), map.getOrDefault(Map.entry(s.charAt(i), count), 0) + 1);
            
            for(int j = i; j < s.length(); j++) {
                if(j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                    map.put(Map.entry(s.charAt(i), count), map.getOrDefault(Map.entry(s.charAt(i), count), 0) + 1);
                } else {
                    break; // if same character substring is finished
                }
            }
        }
        
        int result = -1;
        
                for(Map.Entry<Map.Entry<Character, Integer>, Integer> entry: map.entrySet()) {
                    if(entry.getValue() >= 3) {
                        result = Math.max(entry.getKey().getValue(), result);
                    }
                }
        
        
        return result;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}