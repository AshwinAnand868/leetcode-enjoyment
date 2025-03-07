class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int opening = 0;
        int n = s.length();

        // Getting greedy here
        for(int i = 0; i < s.length(); ++i) {
            char curr = s.charAt(i);

            if(curr == '(') {
                opening++;
            } else {
                if(i < n - 1 && s.charAt(i + 1) == ')') {
                    ++i; // move i to jump to i + 1 index
                } else {
                    res++;
                }

                if(opening > 0) {
                    opening--;
                } else {
                    res++;
                }
            }
        }

        while(opening > 0) {
            res += 2;
            opening--;
        }

        return res;
    }
}