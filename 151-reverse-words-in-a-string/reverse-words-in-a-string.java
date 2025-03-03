class Solution {
    public String reverseWords(String s) {

        s = s.trim(); // trim the spaces

        String[] words = s.split("\\s+");
        int n = words.length;

        StringBuilder sb = new StringBuilder();

        for(int i = n - 1; i >= 0; --i) {
            sb.append(words[i]);

            if(i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}