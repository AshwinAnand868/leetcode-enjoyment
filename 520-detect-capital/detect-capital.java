class Solution {
    public boolean detectCapitalUse(String word) {

        boolean detectedUpper = false;
        boolean detectedLower = false;

        for(int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);

            if(i == 0 && Character.isUpperCase(ch)) continue;

            if(Character.isUpperCase(ch)) {
                detectedUpper = true;
            } else {
                detectedLower = true;
            }

            if(detectedUpper && detectedLower) {
                return false;
            }
        }

        return true;
    }
}