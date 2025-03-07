class Solution {
    public String orderlyQueue(String s, int k) {
        if(k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        } 

        String res = s;
        int n = s.length();

        for(int i = 1; i <= n - 1; ++i) {
            String temp = s.substring(i) + s.substring(0, i);
            if(res.compareTo(temp) > 0) res = temp;
        }

        return res;
    }
}