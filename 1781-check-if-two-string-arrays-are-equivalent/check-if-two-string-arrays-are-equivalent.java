class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0;
        int j = 0;
        int currWord1Index = 0;
        int currWord2Index = 0;

        int m = word1.length;
        int n = word2.length;

        while(currWord1Index < m && currWord2Index < n) {
            if(word1[currWord1Index].charAt(i) != word2[currWord2Index].charAt(j)) {
                return false;
            }

            i++;
            j++;

            if(i == word1[currWord1Index].length()) {
                i = 0;
                currWord1Index++;
            }

            if(j == word2[currWord2Index].length()) {
                j = 0;
                currWord2Index++;
            }
        }

        return currWord1Index == m && currWord2Index == n;
    }
}