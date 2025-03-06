public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int maxLen = Integer.MIN_VALUE;
        String maxStr = "";
        int start = 0;
        int end = 0;

        Boolean[][] memo = new Boolean[n][n];

        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                if(j - i + 1 > maxLen && isPalindrome(s, i, j, memo)) {
                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    private boolean isPalindrome(String s, int i, int j, Boolean[][] memo) {
        if(i >= j) return true; // string traversal is complete and it is palindrome

        if(memo[i][j] != null) return memo[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            memo[i][j] = isPalindrome(s, i + 1, j - 1, memo);
        } else {
            memo[i][j] = false;
        }

        return memo[i][j];
    }

    // private boolean isPalindrome(String str) {
    //     int left = 0;
    //     int right = str.length() - 1;

    //     while (left < right) {
    //         if (str.charAt(left) != str.charAt(right)) {
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }

    //     return true;
    // }
}
