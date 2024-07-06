class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanIntMap = new HashMap<>();
        
        romanIntMap.put('I', 1);
        romanIntMap.put('V', 5);
        romanIntMap.put('X', 10);
        romanIntMap.put('L', 50);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('M', 1000);
        
        int result = 0;
        int len = s.length();
        
        for(int i = 0; i < len; i++) {
            if(i < (len - 1) && romanIntMap.get(s.charAt(i)) < romanIntMap.get(s.charAt(i + 1)) ) {
                result -= romanIntMap.get(s.charAt(i));
            } else {
                result += romanIntMap.get(s.charAt(i));
            }
        }
        
        return result;
        
        
    }
}