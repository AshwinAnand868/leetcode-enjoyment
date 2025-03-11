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

            for(int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                charWordCount[ch - 'a']++;
            }

            valid = true;
            for(int i = 0; i < word.length(); ++i) {
                char curr = word.charAt(i);
                if(tempCharCount[curr - 'a'] >= charWordCount[curr - 'a']) {
                    tempCharCount[curr - 'a']--;
                    charWordCount[curr - 'a']--;
                } else {
                    valid = false;
                }
            }

            if(valid) {
                length += word.length();
            }
        }


        return length;
    }
}