class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToTMapping = new HashMap<>();
        Map<Character, Character> tToSMapping = new HashMap<>();

        for(int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sToTMapping.containsKey(sChar)) {
                if(sToTMapping.get(sChar) != tChar) {
                    return false;
                }
            } else if(tToSMapping.containsKey(tChar)) {
                if(tToSMapping.get(tChar) != sChar) {
                    return false;
                }
            } else {
                sToTMapping.put(sChar, tChar);
                tToSMapping.put(tChar, sChar);
            }
        }

        return true;
    }
}