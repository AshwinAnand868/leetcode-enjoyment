class Solution {
    public boolean isSubsequence(String s, String t) {

        // Using binary search and a hashmap - Good for multiple queries

        HashMap<Character, List<Integer>> map = new HashMap<>();

        // Preprocessing the string t
        for(int i = 0; i < t.length(); ++i) {
            map.computeIfAbsent(t.charAt(i), k -> new ArrayList<>()).add(i);
        }

        int previousIndex = -1; // initially no previous value

        for(char ch : s.toCharArray()) {
            if(!map.containsKey(ch)) {
                return false; // if map never contained that character present in s, then return false
            }

            List<Integer> indices = map.get(ch);

            int index = Collections.binarySearch(indices, previousIndex + 1);
            
            if(index < 0) {
                index = -index - 1; // find where the insertion point should be
            }

            if(index == indices.size()) {
                return false;
            }

            previousIndex = indices.get(index);
        }

        return true;
        // Good for one time query, but for many queries it is not efficient 
        // as we need to scan through t each time
        // int i = 0, j = 0;
        
        // while (i < s.length() && j < t.length()) {
        //     if (s.charAt(i) == t.charAt(j)) {
        //         i++;
        //     }
        //     j++;
        // }
        
        // return i == s.length();
    }
}
