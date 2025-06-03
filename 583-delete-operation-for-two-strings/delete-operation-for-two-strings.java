class Solution {
    public int minDistance(String s1, String s2) {
        int lcsAnswer = lcs(s1, s2);
        int extraCharsS1 = s1.length() - lcsAnswer;
        int extraCharsS2 = s2.length() - lcsAnswer;
        
        return extraCharsS1 + extraCharsS2;
    }
    
    public int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        
        int[][] memo = new int[n][m];
        
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return helper(s1, s2, n - 1, m - 1, memo);
    }
    
    private int helper(String s1, String s2, int i1, int i2, int[][] memo) {
        if(i1 < 0 || i2 < 0) {
            return 0;
        }
        
        if(memo[i1][i2] != -1) {
            return memo[i1][i2];
        }
        
        if(s1.charAt(i1) == s2.charAt(i2)) {
            // if both chars are equal, shrink the strings
            return memo[i1][i2] = 1 + helper(s1, s2, i1 - 1, i2 - 1, memo);
        } else {
            return memo[i1][i2] = Math.max(helper(s1, s2, i1 - 1, i2, memo),
                helper(s1, s2, i1, i2 - 1, memo));
        }
    }
}