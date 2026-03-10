class Solution {
    public int maxDepth(String s) {

        int n = s.length();
        int count = 0;
        int maxNested = Integer.MIN_VALUE;

        for(int i = 0; i < n; ++i) {
            if(s.charAt(i) == '(') {
                count++;
                maxNested = Math.max(count, maxNested);
            } else if(s.charAt(i) == ')') {
                count--;
            }
        }

        return Math.max(count, maxNested);
    }
}