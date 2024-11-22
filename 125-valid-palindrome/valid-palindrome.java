class Solution {
    public boolean isPalindrome(String s) {
        String cleanString = s.replaceAll("[^A-Z0-9a-z]", "").toLowerCase();
        return cleanString.equals(new StringBuilder(cleanString).reverse().toString());
    }
}