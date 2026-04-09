class Solution {
    public String reversePrefix(String s, int k) {
        String firstPart = s.substring(0, k);
        String rest = s.substring(k);

        String reversed = new StringBuilder(firstPart).reverse().toString();

        return reversed + rest;
    }
}