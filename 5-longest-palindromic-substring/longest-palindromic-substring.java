public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int maxLen = Integer.MIN_VALUE;
        String maxStr = "";

        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                if(j - i + 1 > maxLen && isPalindrome(s.substring(i, j + 1))) {
                    maxLen = j - i + 1;
                    maxStr = s.substring(i, j + 1);
                }
            }
        }

        return maxStr;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
