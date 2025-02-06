class Solution {
    public String[] findWords(String[] words) {

        String qwerty = "qwertyuiop";
        String asdf = "asdfghjkl";
        String zx = "zxcvbnm";
        int count1 = 0, count2 = 0, count3 = 0;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (qwerty.indexOf(words[i].toLowerCase().charAt(j)) != -1) {
                    count1++;
                }

                if (asdf.indexOf(words[i].toLowerCase().charAt(j)) != -1) {
                    count2++;
                }

                if (zx.indexOf(words[i].toLowerCase().charAt(j)) != -1) {
                    count3++;
                }
            }

            if(count1 == words[i].length() || count2 == words[i].length() || count3 == words[i].length()) {
                result.add(words[i]);
            }

            count1 = 0;
            count2 = 0;
            count3 = 0;
        }

        return result.toArray(new String[0]);
    }
}