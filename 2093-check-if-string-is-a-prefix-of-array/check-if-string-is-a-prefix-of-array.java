class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < words.length; ++i) {
            builder.append(words[i]);
            if(builder.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }
}