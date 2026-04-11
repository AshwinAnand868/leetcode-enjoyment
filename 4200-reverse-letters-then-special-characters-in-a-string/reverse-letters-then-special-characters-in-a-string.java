class Solution {
    public String reverseByType(String s) {
        StringBuilder letters = new StringBuilder();
        StringBuilder specials = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isLetter(c)) {
                letters.append(c);
            } else {
                specials.append(c);
            }
        }

        letters.reverse();
        specials.reverse();

        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;

        for(char c : s.toCharArray()) {
            if(Character.isLetter(c)) {
                result.append(letters.charAt(i));
                i++;
            } else {
                result.append(specials.charAt(j));
                j++;
            }
        }

        return result.toString();
    }
}