class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, count = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            
            // While the window contains at least one 'a', 'b', and 'c'
            while (freq.getOrDefault('a', 0) > 0 &&
                   freq.getOrDefault('b', 0) > 0 &&
                   freq.getOrDefault('c', 0) > 0) {
                
                // Add the number of valid substrings starting from left
                // If a substring is valid from left = 2 to right = 4, then
                // it will be valid from the same left to righ = 4,5,6,7...
                count += s.length() - right; // no of substrings
                
                // Shrink the window from the left
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left++;
            }
        }
        
        return count;
    }
}