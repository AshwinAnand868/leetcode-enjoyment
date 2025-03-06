class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // one approach is to use string builder and append operation, and then
        // checking at the end if the given words array combined are equal

        // another is the below approach using pointers
        int i = 0, j = 0;
        int currWord1I = 0, currWord2I = 0;

        int m = word1.length;
        int n = word2.length;

        while(currWord1I < m && currWord2I < n) {
            // the arrays can be considered a 2d array
            // one dimension of String instances, and other
            // dimension of characters in each String
            if(word1[currWord1I].charAt(i) != word2[currWord2I].charAt(j)) {
                return false;
            }

            // moves pointers to next character in the current words
            i++;
            j++;

            if(i == word1[currWord1I].length()) {
                i = 0; // moving to the next word of word1
                currWord1I++;
            }

            if(j == word2[currWord2I].length()) {
                j = 0; // moving to the next word of word2
                currWord2I++;
            }
        }

        return currWord1I == m && n == currWord2I;
    }
}