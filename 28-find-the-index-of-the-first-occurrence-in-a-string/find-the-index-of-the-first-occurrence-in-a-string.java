class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int firstIndex = -1;

        int n = needle.length();
        int m = haystack.length();

        while(i < m) {
            char currHaystackChar = haystack.charAt(i);
            char currNeedleChar = needle.charAt(j);


            if(currHaystackChar == currNeedleChar) {
                if(j == 0) {
                    firstIndex = i;
                }

                i++;
                j++;

                if(j == n) {
                    return firstIndex; 
                }
            } else {

                if(j > 0) {
                    i = firstIndex + 1; // potential matches
                } else {
                    i++;
                }

                j = 0;
                firstIndex = -1;
            }
        }

        return -1;
    }
}