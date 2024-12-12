class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        
        if(s.length() < 2) return s.length();
        
        int left = 0;
        int maxLen = 0;
        int cnt = 0;
        
        for(int right = 1; right < s.length(); right++) {
            
            cnt += s.charAt(right) == s.charAt(right - 1) ? 1 : 0;
            
            while(cnt > 1) {
                left++;
                cnt -= s.charAt(left) == s.charAt(left - 1) ? 1 : 0;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
        
    }
}