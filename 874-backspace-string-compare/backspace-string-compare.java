class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder builderS = new StringBuilder();
        StringBuilder builderT = new StringBuilder();

        for(int i = 0; i < s.length(); ++i) {
            while(i < s.length() && s.charAt(i) == '#' && builderS.length() > 0) {
                builderS.deleteCharAt(builderS.length() - 1);
                ++i;
            }
            if(i < s.length() && s.charAt(i) != '#')
                builderS.append(s.charAt(i));
        }


        for(int i = 0; i < t.length(); ++i) {
            while(i < t.length() && t.charAt(i) == '#' && builderT.length() > 0) {
                builderT.deleteCharAt(builderT.length() - 1);
                ++i;
            }
            if(i < t.length() && t.charAt(i) != '#')
                builderT.append(t.charAt(i));
        }


        return builderT.toString().equals(builderS.toString());
    }
}