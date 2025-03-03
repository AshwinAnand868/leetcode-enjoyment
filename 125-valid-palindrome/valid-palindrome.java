class Solution {
    public boolean isPalindrome(String s) {
        String cleanString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        StringBuilder sb = new StringBuilder(cleanString).reverse();

        return cleanString.equals(sb.toString());

    }
}