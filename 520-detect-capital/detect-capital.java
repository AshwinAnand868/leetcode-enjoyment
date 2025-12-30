class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        int n = word.length();
        int lastCapitalIndex = 0;

        for(int i = 0; i < n; ++i) {
            char curr = word.charAt(i);
            if(curr >= 65 && curr <= 90) { 
                capitalCount++;
                lastCapitalIndex = i;
            }
        }

        if(capitalCount == 0) return true;
        if(capitalCount == 1 && lastCapitalIndex == 0) return true;
        if(capitalCount == n) return true;

        return false;
    }
}