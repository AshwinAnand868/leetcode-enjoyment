class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int n = s.length();

        for(Character ch : s.toCharArray()) {
            if(Character.isLetter(ch)) {
                size++;
            } else {
                size *= (ch - '0');
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            k = (int) (k % size);

            if(k == 0 && Character.isLetter(ch)) {
                return String.valueOf(ch);
            }

            if(Character.isLetter(ch)) {
                size--;
            } else {
                size /= (ch - '0');
            }
        }   

        return "";
    }
}