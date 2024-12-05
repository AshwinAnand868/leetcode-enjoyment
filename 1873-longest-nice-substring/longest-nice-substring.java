class Solution {
    public String longestNiceSubstring(String s) {
        if(s.length() < 2)
            return "";
        
        char[] cArr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < cArr.length; i++) set.add(cArr[i]); // populate the set with all the unique characters in the array
        
        for(int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            
            if(set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue; // skip the current iteration if both the lower and upper case characters are present
            
            // divide the array into two halves leaving the current character as it is just one
            String res1 = longestNiceSubstring(s.substring(0, i));
            String res2 = longestNiceSubstring(s.substring(i + 1));
            
            return res1.length() >= res2.length() ? res1 : res2;
        }
        
        return s;
        
    }
}