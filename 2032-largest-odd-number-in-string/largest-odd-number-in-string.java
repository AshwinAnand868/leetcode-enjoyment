class Solution {
    public String largestOddNumber(String num) {

        int n = num.length();
        int oddI = -1;

        for(int i = n - 1; i >= 0; --i) {
            int odd = num.charAt(i) - '0';

            if(odd % 2 != 0) {
                oddI = i;
                break;
            }
        }

        return num.substring(0, oddI + 1);
    }
}