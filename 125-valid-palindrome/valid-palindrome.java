class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        StringBuilder reversed = new StringBuilder(sb.toString().toLowerCase());
        reversed.reverse();

        return sb.toString().toLowerCase().equals(reversed.toString());

        // String cleanString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // StringBuilder sb = new StringBuilder(cleanString).reverse();

        // return cleanString.equals(sb.toString());

    }
}