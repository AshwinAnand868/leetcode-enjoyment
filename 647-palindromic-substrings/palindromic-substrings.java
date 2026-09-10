class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        Boolean[][] memo = new Boolean[n + 1][n + 1];

        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                if(checkPalindrome(i, j, s, memo)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean checkPalindrome(int i, int j, String s, Boolean[][] memo) {
        
        if(i >= j) {
            return memo[i][j] = true;
        }

        if(memo[i][j] != null) {
            return memo[i][j];
        }

        if(s.charAt(i) != s.charAt(j)) {
            return memo[i][j] = false;
        }

        return memo[i][j] = checkPalindrome(i + 1, j - 1, s, memo);
    }
}