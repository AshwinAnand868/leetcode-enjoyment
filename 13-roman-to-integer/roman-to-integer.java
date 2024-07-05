class Solution {
    public int romanToInt(String s) {
     
        Map<Character, Integer> romanIntMap = new HashMap<>();
        romanIntMap.put('I', 1);
        romanIntMap.put('V', 5);
        romanIntMap.put('X', 10);
        romanIntMap.put('L', 50);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('M', 1000);
        
        
        
        int maxIndex = s.length() - 1;

        int result = 0;
        
        for(int i = 0; i < s.length(); i++) {
            
            char x = s.charAt(i);
            
            if(x == 'I') {
                
                if(i == maxIndex) {
                    result += romanIntMap.get(x);
                } else {
                    char nextChar = s.charAt(i + 1);
                
                    if(nextChar == 'V') {
                        result += 4;
                        i++;
                    } else if(nextChar == 'X') {
                        result += 9;
                        i++;
                    } else {
                        result += romanIntMap.get(x);
                    }
                }
                
                
            } else if(x == 'X') {
                
                if(i == maxIndex) {
                    result += romanIntMap.get(x);
                } else {
                    char nextChar = s.charAt(i + 1);
                
                    if(nextChar == 'L') {
                        result += 40;
                        i++;
                    } else if(nextChar == 'C') {
                        result += 90;
                        i++;
                    } else {
                        result += romanIntMap.get(x);
                    }
                }
            } else if (x == 'C') {
                
                if(i == maxIndex) {
                    result += 100;
                } else {
                    char nextChar = s.charAt(i + 1);
                
                    if(nextChar == 'D') {
                        result += 400;
                        i++;
                    } else if(nextChar == 'M') {
                        result += 900;
                        i++;
                    } else {
                        result += romanIntMap.get(x);
                    }
                }
            } else {
                result += romanIntMap.get(x);
            }
                        
        }
        
        return result;
    }
    
}