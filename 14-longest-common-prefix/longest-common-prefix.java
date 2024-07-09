class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        
        if(strs.length == 1) {
            return strs[0];
        }
        
        String res = "";

        for(int i = 0; i < strs[0].length(); i++) {
            for(String str: strs) {
                if(i >= str.length() || str.charAt(i) != strs[0].charAt(i)) {
                    return res;
                }
            }
            
            res += strs[0].charAt(i);
        }
        
        return res;
    }
}