class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] counters = new int[26]; // for storing count of each letter in the sentence

        int count = 0;

        for(int i = 0; i < sentence.length(); ++i) {
            if(counters[sentence.charAt(i) - 'a'] == 0) {
                counters[sentence.charAt(i) - 'a'] = 1;
                count++;
            }
        }

        if(count == 26) return true;
        return false;
    }
}