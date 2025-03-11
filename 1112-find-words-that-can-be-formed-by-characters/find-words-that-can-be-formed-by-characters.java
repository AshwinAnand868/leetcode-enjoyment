class Solution {
    public int countCharacters(String[] words, String chars) {
        int length = 0;
        int[] charsCount = new int[26];
        boolean valid = true;

        for(int i = 0; i < chars.length(); ++i) {
            char ch = chars.charAt(i);
            charsCount[ch - 'a']++;
        }

        for(String word : words) {
            int[] tempCharCount = Arrays.copyOf(charsCount, charsCount.length);

            int[] charWordCount = new int[26];

            valid = true;
            
            for(int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                charWordCount[ch - 'a']++;
                if(charWordCount[ch - 'a'] > tempCharCount[ch - 'a']) {
                    valid = false;
                    break;
                }
            }

            if(valid) {
                length += word.length();
            }
        }


        return length;
    }
}