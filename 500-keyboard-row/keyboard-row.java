class Solution {
    public String[] findWords(String[] words) {

        String[] rows = new String[3];

        Set<Character> row1 = stringToCharSet("qwertyuiop"); 
        Set<Character> row2 = stringToCharSet("asdfghjkl");
        Set<Character> row3 = stringToCharSet("zxcvbnm");

        List<String> res = new ArrayList<>();

        for(String word : words) {
            if(isValid(row1, word) || isValid(row2, word) || isValid(row3, word)){
                res.add(word);    
            }
        }

        return res.toArray(new String[0]);

        // String qwerty = "qwertyuiop";
        // String asdf = "asdfghjkl";
        // String zx = "zxcvbnm";
        // int count1 = 0, count2 = 0, count3 = 0;
        // List<String> result = new ArrayList<>();

        // for (int i = 0; i < words.length; i++) {
        //     for (int j = 0; j < words[i].length(); j++) {
        //         if (qwerty.indexOf(words[i].toLowerCase().charAt(j)) != -1) {
        //             count1++;
        //         }

        //         if (asdf.indexOf(words[i].toLowerCase().charAt(j)) != -1) {
        //             count2++;
        //         }

        //         if (zx.indexOf(words[i].toLowerCase().charAt(j)) != -1) {
        //             count3++;
        //         }
        //     }

        //     if(count1 == words[i].length() || count2 == words[i].length() || count3 == words[i].length()) {
        //         result.add(words[i]);
        //     }

        //     count1 = 0;
        //     count2 = 0;
        //     count3 = 0;
        // }

        // return result.toArray(new String[0]);
    }

    private boolean isValid(Set<Character> row, String word) {
        for(char c : word.toCharArray()) {
            if(!row.contains(Character.toLowerCase(c))) {
                return false;
            }
        }
        return true;
    }

    private Set<Character> stringToCharSet(String str) {
        Set<Character> set = new HashSet<>();

        for(char c: str.toCharArray()) {
            set.add(c);
        }

        return set;
    }
}