class Solution {
    public int strStr(String haystack, String needle) {
        
        final int needleLength = needle.length();
        int index = -1;
        
        for(int i = 0; i < haystack.length(); i++) {
            
               if(i + needleLength > haystack.length()) {
                   break;
               }
            
               String potentialSol = haystack.substring(i, i+needleLength);
                
                if(potentialSol.equals(needle)) {
                    index = i;
                    break;
                }
            
        }
        
        return index;
    }
}