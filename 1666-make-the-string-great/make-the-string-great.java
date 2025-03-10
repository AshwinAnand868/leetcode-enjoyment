class Solution {
    public String makeGood(String s) {
        if(s.length() < 2) return s;
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < s.length(); ++i) {
            if(!sb.isEmpty() 
                && (sb.charAt(sb.length() - 1) + 32 == s.charAt(i) 
                || sb.charAt(sb.length() - 1) - 32 == s.charAt(i))) {

                sb.deleteCharAt(sb.length() - 1);

            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}